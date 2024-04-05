import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.*;

public class mainProbeta {
    public static void main(String[] args) {
        StockArticulosPrueba leche = new StockArticulosPrueba("LECHE", 1.10, true, 20);
            StockArticulosPrueba.inventario.add(leche);
        StockArticulosPrueba pan = new StockArticulosPrueba("PAN", 0.90, true, 30);
            StockArticulosPrueba.inventario.add(pan);
        // StockArticulosPrueba huevos = new StockArticulosPrueba("HUEVOS", 2.50, true, 40);
        //     StockArticulosPrueba.inventario.add(huevos);
        // StockArticulosPrueba arroz = new StockArticulosPrueba("ARROZ", 1.30, false, 15);
        //     StockArticulosPrueba.inventario.add(arroz);
        // StockArticulosPrueba pasta = new StockArticulosPrueba("PASTA", 1.25, false, 25);
        //     StockArticulosPrueba.inventario.add(pasta);
        // StockArticulosPrueba tomates = new StockArticulosPrueba("TOMATES", 2.35, false, 35);
        //     StockArticulosPrueba.inventario.add(tomates);
        // StockArticulosPrueba patatas = new StockArticulosPrueba("PATATAS", 2.10, false, 10);
        //     StockArticulosPrueba.inventario.add(patatas);
        // StockArticulosPrueba manzanas = new StockArticulosPrueba("MANZANAS", 1.75, false, 45);
        //     StockArticulosPrueba.inventario.add(manzanas);


        ventana();
    }

    public static void ventana() {
        StringBuilder productosTXT = new StringBuilder("");
        JFrame frame = new JFrame("Almacen LIDL");
        frame.setSize(1000, 1000);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints posicion = new GridBagConstraints();
        posicion.fill = GridBagConstraints.BOTH; // Rellenar vertical y horizontalmente
        posicion.weightx = 1; // Permitir que los componentes se expandan horizontalmente
        posicion.weighty = 1; // Permitir que los componentes se expandan verticalmente

        JPanel tituloLIDL = new JPanel();
        JPanel botones = new JPanel();
        JPanel productos = new JPanel();

        panelTitulo(tituloLIDL);
        panelBotones(frame, botones, productos, productosTXT);
        panelProductos(productos, productosTXT);

        posicion.gridy = 0;
        panelPrincipal.add(tituloLIDL, posicion);

        posicion.gridy = 1;
        panelPrincipal.add(botones, posicion);

        posicion.gridy = 2;
        panelPrincipal.add(productos, posicion);

        frame.add(panelPrincipal, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void panelTitulo(JPanel tituloLIDL) {
        tituloLIDL.setBackground(Color.BLUE);
        JLabel titulArticulos = new JLabel("LIDL");
        titulArticulos.setFont(new Font("Arial", Font.BOLD, 70));
        titulArticulos.setForeground(Color.YELLOW);
        titulArticulos.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulArticulos.setBorder(new EmptyBorder(5, 10, 5, 10));
        tituloLIDL.add(titulArticulos);
    }

    public static void panelProductos(JPanel productos, StringBuilder productosTXT) {
        productos.setBackground(Color.LIGHT_GRAY);
        productos.setLayout(new BoxLayout(productos, BoxLayout.Y_AXIS));
        productos.setBorder(new EmptyBorder(5, 10, 7, 10));
        DecimalFormat decimales = new DecimalFormat("0.00");
        for (int i = 0; i < StockArticulosPrueba.inventario.size(); i++) {
            StockArticulosPrueba articulo = StockArticulosPrueba.inventario.get(i);
            String producto = articulo.getNombre();
            double precio = articulo.getPrecio();
            String precioFormateado = decimales.format(precio);
            int stock = articulo.getCantidad();

            JLabel labelProductos = new JLabel(
                    "Artículo " + (i+1) + " >  " + producto + ": " + precioFormateado + "€ / " + stock
                            + " unidades en stock");
            labelProductos.setForeground(Color.BLACK);
            productosTXT.append(
                    "Articulo: '" + producto + "'\n\t" + precioFormateado + "€(EUROS)\n\t" + stock
                            + " unidades en stock\n");
            productos.add(labelProductos);
            productos.add(Box.createVerticalStrut(5)); // Agregar relleno vertical entre los componentes
        }
    }

    public static void panelBotones(JFrame frame, JPanel botones, JPanel productos, StringBuilder productosTXT) {
        botones.setLayout(new GridLayout(0, 4));
        botones.setBackground(Color.GRAY);

        JButton anadir = new JButton(escalarImagen("Iconos\\stock.png"));
        modificarBoton(anadir);
        JButton comprar = new JButton(escalarImagen("Iconos\\comprar-articulo.png"));
        modificarBoton(comprar);
        JButton lista = new JButton(escalarImagen("Iconos\\list-task.png"));
        modificarBoton(lista);
        JButton lupa = new JButton(escalarImagen("Iconos\\search.png"));
        modificarBoton(lupa);

        accionesAnadir(frame, anadir, productos, productosTXT);
        accionesComprar(frame, comprar, productos, productosTXT);

        botones.add(comprar);
        botones.add(anadir);
        botones.add(lista);
        botones.add(lupa);
    }

    public static void modificarBoton(JButton boton) {
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public static ImageIcon escalarImagen(String ruta) {
        ImageIcon imagen = new ImageIcon(ruta);
        ImageIcon imagenEscalada = new ImageIcon(imagen.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        return imagenEscalada;
    }

    public static void accionesComprar(JFrame frame, JButton comprar, JPanel productos, StringBuilder productosTXT) {
        DecimalFormat dosDecimales = new DecimalFormat("0.00");
        ArrayList<String> arrayProductos = new ArrayList<>();
        HashMap<String, Integer> cesta = new HashMap<>();

        comprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int qty = 0;
                boolean error = false;
                
                UIManager.put("OptionPane.yesButtonText", "Sí");
                UIManager.put("OptionPane.noButtonText", "No");

                int respuesta = JOptionPane.showConfirmDialog(null, "¿Quieres definir la longitud de tu compra?", "Cesta Lidl", JOptionPane.YES_NO_CANCEL_OPTION);

                if (respuesta == JOptionPane.CANCEL_OPTION || respuesta == JOptionPane.CLOSED_OPTION) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada", "Error 404", JOptionPane.ERROR_MESSAGE);
                } else if (respuesta == JOptionPane.NO_OPTION) {
                    panelesGenerativos();
                } else if (respuesta == JOptionPane.YES_OPTION) {
                    int i = 1;
                    qty = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de artículos a comprar", "Comprar varios artículos", JOptionPane.QUESTION_MESSAGE));
                    while (i <= qty) {
                    // StockArticulosPrueba.comprarArticulo(cesta, respuesta, masArticulos);
                    System.out.println(cesta);
                    i++;
                    }
                }

                // panelCrearTicket(arrayProductos, dosDecimales);

                // actualizarProductos(frame, productos, productosTXT);
            }
        });
    }

    // public static void panelCrearTicket(ArrayList<String> arrayProductos, DecimalFormat dosDecimales) {
    //     StringBuilder texto = new StringBuilder("PRECIO DE LOS ARTICULOS\n");
    //     String producto = "";
    //     int cantidad = 0;
    //     int stockFinal = 0;
    //     double precioIVA = 0.0;
    //     double totalCompra = 0.0;
    //     double totalProducto = 0.0;
    //     boolean masArticulos = false;
    //     boolean articuloEsencial = false;
    //     boolean error = false;
    //     int confirmado = 0;
    //     do {
    //         producto = policiaProducto(seleccionable, producto);
    //         if (producto.equals("- Seleccionar producto -")) {
    //             error = true;
    //         } else {
    //             cantidad = policiaCantidad(cantidadTxt, cantidad);
    //             if (cantidad == 0) {
    //                 error = true;
    //             } else {
    //                 int stockProducto = productoStock.get(producto);
    //                 stockFinal = revisorCantidades(productoStock, stockProducto, stockFinal, cantidad, producto);
    //                 if (stockFinal == 0) {
    //                     error = true;
    //                 } else {
    //                     error = false;
    //                 }
    //             }
    //         }
    //     } while (error);

    //         if (confirmado == JOptionPane.CANCEL_OPTION) {
    //             break;
    //         }

    //         // objeto.reStock(articulo, nuevoStock) (crear el metodo)
    //         productoStock.put(producto, stockFinal);

    //         precioIVA = precioArticuloConIva(productoPrecio, precioIVA, articuloEsencial, producto);

    //         totalProducto = precioIVA * cantidad;
    //         String ivaFormateado = dosDecimales.format(totalProducto);
    //         String totalFormateado = dosDecimales.format(totalProducto);
    //         texto.append("Producto: '" + producto + "'\n    Precio/unidad: <" + ivaFormateado
    //                 + "> / <" + cantidad + ">\n    Precio total: <" + totalFormateado + ">\n\n");

    //         totalCompra += totalProducto;

    //         if (arrayProductos.size() < 2) {
    //             masArticulos = false;
    //             JOptionPane.showMessageDialog(null, "No hay mas artículos para poder comprar, finalice la compra",
    //                     "Artículos máximos", JOptionPane.INFORMATION_MESSAGE);
    //             break;
    //         }

    //         arrayProductos.remove(producto);
    //     } while (!masArticulos);
        
    //     ticket(dosDecimales, texto, totalCompra);
    // }

    public static void panelesGenerativos() {
    DecimalFormat dosDecimales = new DecimalFormat("0.00");
    ArrayList<String> nombreProductos = new ArrayList<>();
    HashMap<String, Integer> cesta = new HashMap<>();
    boolean error = false;

    for (StockArticulosPrueba producto : StockArticulosPrueba.inventario) {
        nombreProductos.add(producto.getNombre());
    }
    System.out.println(nombreProductos.size());
    while (!error) {
        boolean masArticulos = true;
        if (nombreProductos.size() == 2) {
            JOptionPane.showMessageDialog(null, "Has seleccionado toda la variedad de productos que tenemos. Finalice la compra por favor.", "Máximo de productos", JOptionPane.WARNING_MESSAGE);
            error = true;
        }
        JPanel panelComprar = new JPanel(new GridLayout(0, 2));

        panelComprar.add(new JLabel("Nombre del producto: "));
        JComboBox<String> seleccionable = crearSeleccionable(nombreProductos);
        panelComprar.add(seleccionable);

        panelComprar.add(new JLabel("Cantidad:"));
        JTextField cantidadTxt = new JTextField(10);
        panelComprar.add(cantidadTxt);

        panelComprar.add(new JLabel("¿Más articulos?"));
        JCheckBox masArticulosCheck = new JCheckBox();
        panelComprar.add(masArticulosCheck);

        int confirmacion = JOptionPane.showConfirmDialog(null, panelComprar, "Cesta Lidl", JOptionPane.OK_CANCEL_OPTION);
        masArticulos = masArticulosCheck.isSelected();
        if (!masArticulos) {
            error = true;
        }

        if (confirmacion == JOptionPane.CANCEL_OPTION || confirmacion == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada", "Error 404", JOptionPane.ERROR_MESSAGE);
        } else {
            String producto = (String) seleccionable.getSelectedItem();
            if (producto != null && !producto.equals("- Seleccionar producto -")) {
                Policias poliCantidad = new Policias(cantidadTxt, "enteros");
                if (poliCantidad.getBoolean()) {
                    int cantidad = Integer.parseInt(cantidadTxt.getText());
                    nombreProductos.remove(producto);

                    //llamar método
                    cesta.put(producto, cantidad);
                } else {
                    JOptionPane.showMessageDialog(null, "La cantidad debe ser un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione un producto válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}


    public static void ticket(DecimalFormat dosDecimales, StringBuilder texto, double totalCompra) {
        String laMulta = dosDecimales.format(totalCompra);
        double losBilletes = Double
                .parseDouble(JOptionPane.showInputDialog(null, texto.toString() + "\nTotal a pagar: " + laMulta));
        double cambio = losBilletes - totalCompra;
        String laCalderilla = dosDecimales.format(cambio);
        JOptionPane.showMessageDialog(null,
                "Has pagado el precio de " + laMulta + " con " + losBilletes + "\nTus vueltas son ==> " + laCalderilla);
    }

    public static JComboBox<String> crearSeleccionable(ArrayList<String> inventario) {
        String[] productos = new String[(inventario.size() + 1)];
        productos[0] = "- Seleccionar producto -";

        for (int i = 0; i < inventario.size(); i++) {
            String producto = inventario.get(i);
            productos[(i+1)] = producto;
        }
        JComboBox<String> seleccionable = new JComboBox<>(productos);

        return seleccionable;
    }

    public static void accionesAnadir(JFrame frame, JButton anadir, JPanel productos, StringBuilder productosTXT) {
        anadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel cantidad = new JPanel(new GridLayout(0, 2));

                cantidad.add(new JLabel("Cantidad del producto: "));
                JTextField cantidadTxt = new JTextField(10);
                cantidad.add(cantidadTxt);

                int opcion = JOptionPane.showConfirmDialog(null, cantidad, "Ingrese la cantidad", JOptionPane.OK_CANCEL_OPTION);

                boolean error = false;
                int qty = 0;
                try {
                    qty = Integer.parseInt(cantidadTxt.getText());
                    error = false;
                } catch (Exception et) {
                    error = true; 
                }  

                if (opcion == JOptionPane.CANCEL_OPTION || opcion == JOptionPane.CLOSED_OPTION || error) {
                    JOptionPane.showMessageDialog(null, "No se ha introducido una cantidad válida", "ERROR 404", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (int i = 1; i <= qty; i++) {
                        StockArticulosPrueba.agregarArticulo();
                    }
                    actualizarProductos(frame, productos, productosTXT);
                }
            }
        });
    }

    public static void actualizarProductos(JFrame frame, JPanel productos, StringBuilder productosTXT) {

        frame.setVisible(false);
        frame.setSize(1000, 1000);
        productos.removeAll();
        DecimalFormat decimales = new DecimalFormat("0.00");
        for (int i = 0; i < StockArticulosPrueba.inventario.size(); i++) {
            StockArticulosPrueba articulo = StockArticulosPrueba.inventario.get(i);
                if (i <= 20) {
                    String producto = articulo.getNombre();
                    double precio = articulo.getPrecio();
                    String precioFormateado = decimales.format(precio);
                    int stock = articulo.getCantidad();


                    JLabel labelProductos = new JLabel(
                            "Artículo " + (i+1) + " >  " + producto + ": " + precioFormateado + "€ / " + stock
                                    + " unidades en stock");
                    labelProductos.setForeground(Color.BLACK);
                    productosTXT.append(
                            "Articulo: '" + producto + "'\n\t" + precioFormateado + "€(EUROS)\n\t" + stock
                                    + " unidades en stock\n");
                    productos.add(labelProductos);
                    productos.add(Box.createVerticalStrut(5));
                } else {
                    JOptionPane.showMessageDialog(null, "Has llegado al máximo de artículos posible");
                }
            }
            productos.revalidate();
            productos.repaint();

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}