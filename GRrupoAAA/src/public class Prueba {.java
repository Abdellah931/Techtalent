public class Prueba {
    public static void accionesComprar(JFrame frame, JButton comprar, JPanel productos, StringBuilder productosTXT) {
        DecimalFormat dosDecimales = new DecimalFormat("0.00");
        ArrayList<String> arrayProductos = new ArrayList<>();
        comprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                HashMap<String, Integer> cesta = new HashMap<>();
                int qty = 0;
                boolean error = false;
                

                UIManager.put("OptionPane.yesButtonText", "Sí");
                UIManager.put("OptionPane.noButtonText", "No");

                boolean masArticulos = false;
                ArrayList<String> nombreProductos = new ArrayList<>();
                int i = 0;
                for (StockArticulosPrueba producto : StockArticulosPrueba.inventario) {
                    nombreProductos.add(producto.getNombre());
                    i++;
                }
                

                int respuesta = JOptionPane.showConfirmDialog(null, "¿Quieres definir la longitud de tu compra?", "Cesta Lidl", JOptionPane.YES_NO_CANCEL_OPTION);

                if (respuesta == JOptionPane.CANCEL_OPTION || respuesta == JOptionPane.CLOSED_OPTION) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada", "Error 404", JOptionPane.ERROR_MESSAGE);
                } else if (respuesta == JOptionPane.NO_OPTION) {
                    do {
                        if (nombreProductos.size()<2) {
                            JOptionPane.showMessageDialog(null, "No quedan más productos, termine la compra", "Sin artículos", JOptionPane.WARNING_MESSAGE);
                            break;
                        } else {
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
                            masArticulos = masArticulosCheck.isSelected() ? true : false;   

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
                        

                        StockArticulosPrueba.comprarArticulo(cesta, respuesta);
                        System.out.println(cesta);
                    } while (masArticulos);

                // int stockProducto = productoStock.get(producto);
                // stockFinal = revisorCantidades(productoStock, stockProducto, stockFinal, cantidad, producto);
                // if (stockFinal == 0) {
                //     error = true;
                // } else {

                } else if (respuesta == JOptionPane.YES_OPTION) {
                    // int i = 1;
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
}
