/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Proyecto: MiProyectoTeclaC
 * Autor: Genesis Andy
 * 
 * Ejemplo: Captura de la tecla 'C' 
 */
public class MiVentanaTeclaC extends JFrame {

    private JList<String> lista;
    private DefaultListModel<String> modelo;

    public MiVentanaTeclaC() {
        setTitle("Mi Proyecto - Tecla C");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Modelo para la lista
        modelo = new DefaultListModel<>();
        modelo.addElement("Elemento 1");
        modelo.addElement("Elemento 2");
        modelo.addElement("Elemento 3");
        lista = new JList<>(modelo);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Botón de ejemplo
        JButton boton = new JButton("Botón de prueba");

        // --- Captura de tecla 'C' usando Key Binding ---
        InputMap im = lista.getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap am = lista.getActionMap();

        // Asociar tecla C a la acción "accionC"
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "accionC");

        // Definir lo que pasa cuando se presiona C
        am.put("accionC", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = lista.getSelectedIndex();
                if (index != -1) {
                    String item = modelo.get(index);
                    // Alternar estado del elemento
                    if (item.startsWith("[X] ")) {
                        modelo.set(index, item.substring(4));
                    } else {
                        modelo.set(index, "[X] " + item);
                    }
                    System.out.println("Presionaste C sobre: " + item);
                } else {
                    System.out.println("Selecciona un elemento antes de presionar C.");
                }
            }
        });

        // Layout de la ventana
        setLayout(new BorderLayout());
        add(new JScrollPane(lista), BorderLayout.CENTER);
        add(boton, BorderLayout.SOUTH);

        // Asegurar que la lista tenga el foco
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                lista.requestFocusInWindow();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MiVentanaTeclaC().setVisible(true));
    }
}
