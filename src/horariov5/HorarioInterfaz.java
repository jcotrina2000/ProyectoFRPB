/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package horariov5;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import writer.EscritorArchivo;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class HorarioInterfaz extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;
    private JLabel lblNumeroParcial;
    private int semanaActual = 1;
    private JLabel lblNumeroSemana; // Etiqueta para mostrar el número de semana
    private HorarioTableModel model;

    public HorarioInterfaz() {
        setTitle("Horario de 16 Semanas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Establecer la ventana en modo de pantalla completa
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setLayout(new BorderLayout());
        
        model = new HorarioTableModel();
        table = new JTable(model);
        
        
       
        
        table.setBackground(Color.lightGray);
        table.setRowHeight(80); // Cambia el valor 30 por el alto deseado en píxeles
        
         // Configura el TableCellRenderer personalizado para permitir múltiples líneas
        TableCellRenderer multilineCellRenderer = new MultilineTableCellRenderer();
        table.getColumnModel().getColumn(1).setCellRenderer(multilineCellRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(multilineCellRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(multilineCellRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(multilineCellRenderer);
        table.getColumnModel().getColumn(5).setCellRenderer(multilineCellRenderer);// Columna donde deseas tener múltiples líneas


        
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        
        // Establecer el tamaño preferido de la tabla
        table.setPreferredScrollableViewportSize(new Dimension(600, 400));

        // Inicializar la etiqueta del número de semana
        lblNumeroSemana = new JLabel("Semana " + semanaActual, SwingConstants.CENTER);
        add(lblNumeroSemana, BorderLayout.NORTH);
        
        lblNumeroParcial = new JLabel("Parcial " + obtenerNumeroParcial(semanaActual), SwingConstants.CENTER);
        add(lblNumeroParcial, BorderLayout.WEST);
        

        JButton btnAvanzar = new JButton("Avanzar Semana");
        btnAvanzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avanzarSemana();
            }
        });

        JButton btnRetroceder = new JButton("Retroceder Semana");
        btnRetroceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retrocederSemana();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnRetroceder);
        buttonPanel.add(btnAvanzar);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        updateData();
    }

    private void avanzarSemana() {
        if (semanaActual < 16) {
            semanaActual++;
            updateData();
            actualizarEtiquetaSemana();
        }
    }

    private void retrocederSemana() {
        if (semanaActual > 1) {
            semanaActual--;
            updateData();
            actualizarEtiquetaSemana();
        }
    }

    private void updateData() {
        String[][] data = new String[13][6]; // 24 horas al día, 5 días de la semana (lunes a viernes)

        //Horario h1 = new Horario("101ABC",1,49,"01:00","03:00");
        
        /*String[] result = getDayAndWeek(h1.getDia());
        System.out.println("Dia de la semana: "+result[0]);
        int indiceDia = obtenerIndiceDia(result[0]);
        System.out.println("indiceDia: "+indiceDia);*/

        
        lblNumeroParcial.setText("Parcial " + obtenerNumeroParcial(semanaActual));
        

        //int val = 0;
        //boolean cond = Integer.toString(semanaActual).equals(result[1]);
        //System.out.println("boolean: "+cond);
        
        try (FileReader fileReader = new FileReader("src/admFiles/paralelos.adm");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            // Leer la primera línea (cabecera) y omitirla, ya que no contiene datos a procesar
            String cabecera = bufferedReader.readLine();

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                // Procesar cada línea y dividirla en sus campos usando el delimitador ","
                String[] campos = linea.split(",");

                // Obtener los valores de cada campo
                String codigoMateria = campos[0];
                int numeroParalelo = Integer.parseInt(campos[1]);
                int cantidadEstudiantes = Integer.parseInt(campos[2]);
                int horasMaximas = Integer.parseInt(campos[3]);
                int dia = Integer.parseInt(campos[4]);
                String horaInicio = campos[5];
                String horaFin = campos[6];     
                String tipoActividad = campos[8];
                String idTema = campos[9];
                
                
                String[] result = getDayAndWeek(dia);
                int indiceDia = obtenerIndiceDia(result[0]);
                boolean cond = Integer.toString(semanaActual).equals(result[1]);
                int iFila = obtenerIndiceFila(horaInicio);
                if(cond){
                    //for (int row = 0; row < 13; row++) {
                        //for (int col = 0; col < 6; col++) {   
                    System.out.println("CodigoMateriaBucle: "+ codigoMateria);
                    data[iFila][indiceDia] = "Codigo materia: " + codigoMateria + "\nParalelo: " + numeroParalelo + "\nTipo Actividad: "+tipoActividad +"\nidTema :"+idTema;                                             
                }
                    //}
                //}
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        /*if(cond){
            for (int row = 0; row < 13; row++) {
                for (int col = 0; col < 6; col++) {          
                    if(col==indiceDia){
                        data[row][col] = "Actividad: " + h1.getCodigoMateria() + " - Semana " + semanaActual;              
                    }
                }
            }
        }*/

        model.setData(data);
        model.fireTableDataChanged();
    }
    
    private int obtenerNumeroParcial(int semana) {
        if (semana >= 1 && semana <= 8) {
            return 1;
        } else if (semana >= 9 && semana <= 16) {
            return 2;
        } else {
            return 0; // Valor por defecto en caso de que no esté en el rango 1-16
        }
    }
    private int obtenerIndiceFila(String horaInicio){
        String[] horas = {"07:00-08:00", "08:00-09:00", "09:00-10:00", "10:00-11:00", "11:00-12:00", "12:00-13:00", "13:00-14:00", "14:00-15:00", "15:00-16:00", "16:00-17:00", "17:00-18:00", "18:00-19:00", "19:00-20:00", "20:00-21:00", "21:00-22:00"};
        int indice = 0;
        for(String arr : horas){
            String[] subcadenas = arr.split("-"); 
            if (subcadenas[0].equals(horaInicio)){
                return indice;
            }
            indice++;
        }
        return 0;
    }
    
    public static String[] getDayAndWeek(int dayNumber) {
        if (dayNumber < 1 || dayNumber > 80) {
            throw new IllegalArgumentException("El número de día debe estar entre 1 y 80.");
        }

        String[] daysOfWeek = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        int daysPerWeek = daysOfWeek.length;
        int weekNumber = (dayNumber - 1) / daysPerWeek + 1;
        int dayOfWeekIndex = (dayNumber - 1) % daysPerWeek;

        String dayOfWeek = daysOfWeek[dayOfWeekIndex];
        String week = Integer.toString(weekNumber);

        return new String[]{dayOfWeek, week};
    }
    
    
    public static int obtenerIndiceDia(String diaSemana) {
        String[] diasSemana = {"Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        for (int i = 0; i < diasSemana.length; i++) {
            if (diasSemana[i].equalsIgnoreCase(diaSemana)) {
                return i;
            }
        }
        // Si el día de la semana no coincide con ninguno de los días en el arreglo, devolver -1 o lanzar una excepción.
        return -1;
    }

    private void actualizarEtiquetaSemana() {
        lblNumeroSemana.setText("Semana " + semanaActual);
    }
    

    public static void main(String[] args) {
        /*Añadir materias a los archivos*/
        List<Materia> materias = new ArrayList<>();
        EscritorArchivo escritor = new EscritorArchivo();
        Materia materia1 = new Materia("MATH101", "Matematicas", 6);
        Materia materia2 = new Materia("PHYS202", "Fisica", 4);
        Materia materia3 = new Materia("CS110", "Programacion", 2);
        
        materias.add(materia1);
        materias.add(materia2);
        materias.add(materia3);
        escritor.escribirMateriasEnArchivo(materias, "src/admFiles/materias.adm");
        
        /*Añadir Paralelos a los archivos*/
        List<Paralelo> paralelos = new ArrayList<>();
        List<Horario> horarios = new ArrayList<>();
        List<Horario> horarios2 = new ArrayList<>();
        //List<Horario> horario1 = new ArrayList<>();
        List<Actividad> actividades = new ArrayList<>();
        Actividad actividad1 = new Actividad(TipoActividad.LECCION, 1);
        actividades.add(actividad1);
        Clase clase1 = new Clase(1,"19-08-2023",actividades);
        Clase clase2 = new Clase(2, "19-08-2023",actividades);
        Horario horario1 = new Horario("MATH101", 1, 5, "10:00", "11:00",clase1);
        Horario horario2 = new Horario("MATH101", 1, 10, "11:00", "12:00", clase2);
        //Horario horario3 = new Horario("PHYS202", 2, 15, "12:00", "13:00");
        //Horario horario4 = new Horario("PHYS202", 2, 25, "13:00", "14:00");
        
        horarios.add(horario1);
        horarios.add(horario2);
        //horarios2.add(horario3);
        //horarios2.add(horario4);

        
        Paralelo paralelo1 = new Paralelo("MATH101", 1, 35, materia1, horarios);
        Paralelo paralelo2 = new Paralelo("PHYS202", 2, 30, materia2, horarios2);
        paralelos.add(paralelo1);
        paralelos.add(paralelo2);
        
        
        escritor.escribirParalelosEnArchivo(paralelos, "src/admFiles/paralelos.adm");
        
        /*Añadir horarios a horarios.adm*/
        escritor.escribirHorariosEnArchivo(horarios, "src/admFiles/horarios.adm");
        
        /*Añadir temas a temas.adm*/
        List<Tema> temas = new ArrayList<>();
        Tema tema1 = new Tema("Funciones lineales", 2, "Matematicas");
        Tema tema2 = new Tema("Funciones cuadraticas", 1, "Matematicas");
        temas.add(tema1);
        temas.add(tema2);
        
        escritor.escribirTemasEnArchivo(temas, "src/admFiles/temas.adm");
        
        
        SwingUtilities.invokeLater(() -> new HorarioInterfaz());
    }
}

class HorarioTableModel extends AbstractTableModel {
    private String[] diasSemana = {"Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
    private String[][] data;

    public HorarioTableModel() {
        data = new String[13][6];
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return data[0].length;
    }
    
     @Override
    public String getColumnName(int column) {
        return diasSemana[column];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            // Calcular la hora a partir del índice de fila
            int horaInicio = rowIndex + 7; // Empezar desde las 7 y sumar el índice de fila
            int horaFin = rowIndex + 8;    // Sumar 1 para obtener la hora de fin

            // Asegurarse de que la hora de fin no supere las 22
            if (horaFin > 22) {
                horaFin = 22;
            }

            String horaInicioStr = String.format("%02d:00", horaInicio);
            String horaFinStr = String.format("%02d:00", horaFin);

            return horaInicioStr + "-" + horaFinStr;
        } else {
            // Devolver los datos almacenados en la matriz data para las otras columnas
            return data[rowIndex][columnIndex];
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void setData(String[][] newData) {
        data = newData;
    }
    
}

class MultilineTableCellRenderer extends JTextArea implements TableCellRenderer {
    public MultilineTableCellRenderer() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
        setEditable(false);
        setAlignmentX(CENTER_ALIGNMENT); // Centrar el texto horizontalmente
        setAlignmentY(CENTER_ALIGNMENT); // Centrar el texto verticalmente
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        setText(value != null ? value.toString() : "");
        setAlignmentX(CENTER_ALIGNMENT); // Centrar el texto horizontalmente
        setAlignmentY(CENTER_ALIGNMENT);
        return this;
    }
}









