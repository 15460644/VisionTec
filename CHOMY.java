package chomy;

import java.util.Random;
import javax.swing.JOptionPane;

public class CHOMY {

    public static void main(String[] args) {
        String diaFin = null, videojuego = null, serie = null, diaInicio = null, clasificacion = null, mesInicio = null, genero = null, nombre = null, calidad = null, plataforma = null, propietario = null, director = null, peli = null, peliculaDevolucion = null, serieDevolucion = null, videojuegosDevolucion = null;
        int videojuegosNipDevolucion = 0, serieNipDevolucion = 0, peliculaNipDevolucion = 0, pel = -1, ser = -1, vide = -1, encontrar = 0, entrega = 0, diferenciaDias = 0, opcionDevolucion = 0, devolucion = 0, vBuena = 0, sBuena = 0, pBuena = 0, salir = 0, catalogo = 0, contadorPelicula = -1, contadorSerie = -1, contadorVideojuegos = -1, cuantos = 0, alta = 0, opcion = 0, cont = -1, nip = 0, renta = 0, añoInicio = 0, especifico = 0, lanzamiento = 0, totalPelicula = 0, totalSerie = 0, totalVideojuegos = 0, duracion = 0;
        byte discos = 0, temporada = 0, numero = 0;
        boolean p = false, s = false, v = false;
        float precio = 0.0f, extra = 0.0f;

        Random aleatorio = new Random();

        JOptionPane.showMessageDialog(null, "Primeramente daremos de alta todo lo que tengamos en existencia", "INVENTARIO", 1);
        JOptionPane.showMessageDialog(null, "Ingresa la cantidad de altas que darás de cada tipo", "INVENTARIO", 1);

        do {
            totalPelicula = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuántas Peliculas va a dar de alta?", "ALTA PELICULAS", 3));
            if (totalPelicula < 0) {
                JOptionPane.showMessageDialog(null, "Usted ingreso una cantidad errónea\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
            }
        } while (totalPelicula < 0);

        do {
            totalSerie = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuántas Series va a dar de alta?", "ALTA SERIES", 3));
            if (totalSerie < 0) {
                JOptionPane.showMessageDialog(null, "Usted ingreso una cantidad errónea\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
            }
        } while (totalSerie < 0);

        do {
            totalVideojuegos = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuántos Videojuegos va a dar de alta?", "ALTA VIDEOJUEGOS", 3));
            if (totalVideojuegos < 0) {
                JOptionPane.showMessageDialog(null, "Usted ingreso una cantidad errónea\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
            }
        } while (totalVideojuegos < 0);

        Series SERIE[] = new Series[totalSerie];
        Peliculas PELI[] = new Peliculas[totalPelicula];
        Videojuegos VIDEOGAMES[] = new Videojuegos[totalVideojuegos];

        do {
            alta = JOptionPane.showOptionDialog(null, "¿QUÉ VA A DAR DE ALTA?", "DAR DE ALTA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"PELICULAS", "SERIES", "VIDEOJUEGOS", "TERMINAR DE DAR DE ALTA"}, null);

            switch (alta) {
                //PELICULAS                
                case 0:
                    if (contadorPelicula >= (totalPelicula - 1)) {
                        JOptionPane.showMessageDialog(null, " Usted ya no puede usar éste apartado,\n El vector ésta lleno, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                    } else {
                        do {
                            contadorPelicula++;

                            JOptionPane.showMessageDialog(null, "Dar de alta pelicula # " + (contadorPelicula + 1), "Contador", JOptionPane.INFORMATION_MESSAGE);

                            do {
                                nombre = JOptionPane.showInputDialog(null, "Título:", "Ingreso de Datos", 3);
                                if (nombre.equals("")) {
                                    JOptionPane.showMessageDialog(null, "Usted dejo el espacio vacio\n Le pedimos de favor, que ingrese el nombre\n Lamentamos las molestias", "ERROR", 2);
                                }
                            } while (nombre.equals(""));

                            do {
                                lanzamiento = Integer.parseInt(JOptionPane.showInputDialog(null, "Año de lanzamiento:\n Mayor o igual a 1500 y Menor o Igual a 2016", "Ingreso de Datos", 3));
                                if (lanzamiento < 1500 || lanzamiento > 2016) {
                                    JOptionPane.showMessageDialog(null, "Usted ingreso una fecha errónea\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);

                                    if (lanzamiento < 1500) {
                                        JOptionPane.showMessageDialog(null, "Usted ingreso una fecha menor a 1500\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Usted ingreso una fecha mayor a 2016\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
                                    }
                                }
                            } while (lanzamiento < 1500 || lanzamiento > 2016);

                            do {
                                director = JOptionPane.showInputDialog(null, "Director de la Pelicula:", "Ingreso de Datos", 3);
                                if (director.equals("") || nombre.equalsIgnoreCase("rentada")) {
                                    JOptionPane.showMessageDialog(null, "Usted dejo el espacio vacio\n Le pedimos de favor, que ingrese el nombre\n Lamentamos las molestias", "ERROR", 2);
                                }
                            } while (director.equals("") || nombre.equalsIgnoreCase("rentada"));

                            genero = (String) JOptionPane.showInputDialog(null, "GENERO DE LA PELICULA", "Ingreso de datos", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"ACCIÓN", "CIENCIA FICCIÓN", "ANIMACIÓN", "AVENTURAS", "COMEDIA", "DEPORTIVA", "DOCUMENTAL", "DRAMÁTICA", "ERÓTICA", "HISTORICAS", "INFANTILES", "INTRIGA", "MISTERIO", "MUSICAL", "ROMANTICAS", "TERROR"}, "SELECCIONE UNA OPCIÓN");
                            clasificacion = (String) JOptionPane.showInputDialog(null, "CLASIFICACIÓN DE LA PELICULA", "Ingreso de datos", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"AA", "A", "B", "B-15", "C", "D"}, "SELECCIONE UNA OPCIÓN");

                            do {
                                duracion = Integer.parseInt(JOptionPane.showInputDialog(null, "Duración de la pelicula:(en minutos)", "DURACIÓN PELICULA", 3));
                                if (duracion <= 0) {
                                    JOptionPane.showMessageDialog(null, "Usted ingreso una duración errónea\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
                                }
                            } while (duracion <= 0);

                            calidad = (String) JOptionPane.showInputDialog(null, "Formato de la Pelicula", "Ingreso de datos", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"DVD", "BLU-RAY", "CASSETTE"}, "SELECCIONE UNA OPCIÓN");

                            PELI[contadorPelicula] = new Peliculas(calidad, director, duracion, clasificacion, genero, nombre, lanzamiento, propietario, nip, añoInicio, diaInicio, diaFin, mesInicio, precio);

                        } while (contadorPelicula < (totalPelicula - 1));
                    }
                    break;

                //SERIES
                case 1:
                    if (contadorSerie >= (totalSerie - 1)) {
                        JOptionPane.showMessageDialog(null, " Usted ya no puede usar éste apartado,\n El vector ésta lleno, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                    } else {
                        do {
                            contadorSerie++;
                            JOptionPane.showMessageDialog(null, "Dar de alta Serie # " + (contadorSerie + 1), "Contador", JOptionPane.INFORMATION_MESSAGE);

                            do {
                                nombre = JOptionPane.showInputDialog(null, "Título:", "Ingreso de Datos", 3);
                                if (nombre.equals("") || nombre.equalsIgnoreCase("rentada")) {
                                    JOptionPane.showMessageDialog(null, "Usted dejo el espacio vacio\n Le pedimos de favor, que ingrese el nombre\n Lamentamos las molestias", "ERROR", 2);
                                }
                            } while (nombre.equals("") || nombre.equalsIgnoreCase("rentada"));

                            do {
                                lanzamiento = Integer.parseInt(JOptionPane.showInputDialog(null, "Año de lanzamiento:", "Ingreso de Datos", 3));
                                if (lanzamiento < 1500 || lanzamiento > 2016) {
                                    JOptionPane.showMessageDialog(null, "Usted ingreso una fecha errónea\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
                                    
                                    if (lanzamiento < 1500) {
                                        JOptionPane.showMessageDialog(null, "Usted ingreso una fecha menor a 1500\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Usted ingreso una fecha mayor a 2016\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
                                    }
                                }
                            } while (lanzamiento < 1500 || lanzamiento > 2016);

                            do {
                                director = JOptionPane.showInputDialog(null, "Director de la Serie:", "Ingreso de Datos", 3);
                                if (director.equals("")) {
                                    JOptionPane.showMessageDialog(null, "Usted dejo el espacio vacio\n Le pedimos de favor, que ingrese el nombre\n Lamentamos las molestias", "ERROR", 2);
                                }
                            } while (director.equals(""));

                            do {
                                temporada = Byte.parseByte(JOptionPane.showInputDialog(null, "Temporada de la serie:", "Ingreso de datos", 3));
                                if (temporada <= 0) {
                                    JOptionPane.showMessageDialog(null, "Usted ingresó un dato erróneo\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
                                }
                            } while (temporada <= 0);

                            do {
                                discos = Byte.parseByte(JOptionPane.showInputDialog(null, "¿Cuántos discos tiene la serie?", "Ingreso de datos", 3));
                                if (discos <= 0) {
                                    JOptionPane.showMessageDialog(null, "Usted ingresó un dato erróneo\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
                                }
                            } while (discos <= 0);

                            genero = (String) JOptionPane.showInputDialog(null, "GENERO DE LA SERIE", "Ingreso de datos", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"ACCIÓN", "CIENCIA FICCIÓN", "ANIMACIÓN", "AVENTURAS", "COMEDIA", "DEPORTIVA", "DOCUMENTAL", "DRAMÁTICA", "ERÓTICA", "HISTORICAS", "INFANTILES", "INTRIGA", "MISTERIO", "MUSICAL", "ROMANTICAS", "TERROR"}, "SELECCIONE UNA OPCIÓN");
                            clasificacion = (String) JOptionPane.showInputDialog(null, "CLASIFICACIÓN DE LA SERIE", "Ingreso de datos", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"TV-Y", "TV-Y7", "TV-Y7-FV", "TV-G", "TV-PG", "TV-14", "TV-MA"}, "SELECCIONE UNA OPCIÓN");

                            SERIE[contadorSerie] = new Series(discos, temporada, director, clasificacion, genero, nombre, propietario, nip, añoInicio, lanzamiento, diaInicio, diaFin, mesInicio, precio);
                        } while (contadorSerie < (totalSerie - 1));
                    }
                    break;

                //VIDEOJUEGOS
                case 2:
                    if (contadorVideojuegos >= (totalVideojuegos - 1)) {
                        JOptionPane.showMessageDialog(null, " Usted ya no puede usar éste apartado,\n El vector ésta lleno, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                    } else {
                        do {
                            contadorVideojuegos++;
                            JOptionPane.showMessageDialog(null, "Dar de alta Videojuego # " + (contadorVideojuegos + 1), "Contador", JOptionPane.INFORMATION_MESSAGE);

                            do {
                                nombre = JOptionPane.showInputDialog(null, "Título:", "Ingreso de Datos", 3);
                                if (nombre.equals("") || nombre.equalsIgnoreCase("rentada")) {
                                    JOptionPane.showMessageDialog(null, "Usted dejo el espacio vacio\n Le pedimos de favor, que ingrese el nombre\n Lamentamos las molestias", "ERROR", 2);
                                }
                            } while (nombre.equals("") || nombre.equalsIgnoreCase("rentada"));

                            do {
                                lanzamiento = Integer.parseInt(JOptionPane.showInputDialog(null, "Año de lanzamiento:", "Ingreso de Datos", 3));
                                if (lanzamiento < 1500 || lanzamiento > 2016) {
                                    JOptionPane.showMessageDialog(null, "Usted ingreso una fecha errónea\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);

                                    if (lanzamiento < 1500) {
                                        JOptionPane.showMessageDialog(null, "Usted ingreso una fecha menor a 1500\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Usted ingreso una fecha mayor a 2016\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
                                    }
                                }
                            } while (lanzamiento < 1500 || lanzamiento > 2016);

                            plataforma = (String) JOptionPane.showInputDialog(null, "PLATAFORMA DE VIDEOJUEGOS", "Ingreso de datos", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"XBOX", "XBOX 360", "XBOX ONE", "PLAY STATION 2", "PLAY STATION 3", "PLAY STATION 4", "PSP", "WII", "WII-U", "NINTENDO DS", "NINTENDO 3DS", "PC"}, "SELECCIONE UNA OPCIÓN");
                            genero = (String) JOptionPane.showInputDialog(null, "GENERO DE LA PELICULA", "Ingreso de datos", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"ACCIÓN", "DISPAROS", "ESTRATEGIA", "SIMULACIÓN", "DEPORTE", "CARRERAS", "AVENTURA", "ROL", "SANDBOX", "MUSICAL", "EDUCACIÓN"}, "SELECCIONE UNA OPCIÓN");
                            clasificacion = (String) JOptionPane.showInputDialog(null, "CLASIFICACIÓN DE LA PELICULA", "Ingreso de datos", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"eC - Niños Pequeños", "E - Todos", "E 10+ - Todos más de 10 años", "T - Adolescentes", "M - Mayor de 17 años", "AO - Solamente mayores de 18 años", "RP - Clasificación Pendiente"}, "SELECCIONE UNA OPCIÓN");

                            VIDEOGAMES[contadorVideojuegos] = new Videojuegos(plataforma, clasificacion, genero, nombre, propietario, nip, añoInicio, lanzamiento, diaInicio, diaFin, mesInicio, precio);
                        } while (contadorVideojuegos < (totalVideojuegos - 1));
                    }
                    break;

                case 3:
                    if (contadorVideojuegos < (totalVideojuegos - 1) || contadorSerie < (totalSerie - 1) || contadorPelicula < (totalPelicula - 1)) {
                        salir = JOptionPane.showConfirmDialog(null, " ¡¡ Le quedan espacios para seguir dando de alta !!\n ¿Realmente desea salir de DAR DE ALTA?", "CONFIRMAR SALIDA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (salir == 1) {
                            alta = 1;
                        }
                    }
                    break;
            }
        } while (alta != 3);

        do {
            cuantos = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuántos movimientos va a realizar el día de hoy?", "VECTOR", 3));
            if (cuantos <= 0) {
                JOptionPane.showMessageDialog(null, "Usted ingreso una cantidad errónea\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
            }
        } while (cuantos <= 0);

        VisionTec VISION[] = new VisionTec[cuantos];
        VisionTec RENTAS[] = new VisionTec[cuantos];

        do {
            opcion = JOptionPane.showOptionDialog(null, "¿QUÉ DESEA HACER?", "MENÚ PRINCIPAL", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"VER CATÁLOGO GENERAL", "RENTAR", "DEVOLUCIÓN", "MOSTRAR TODOS", "MOSTRAR ESPECIFICO", "SALIR"}, null);

            switch (opcion) {
                //VER CATÁLOGO GENERAL   
                case 0:

                    if (contadorPelicula == -1 && contadorSerie == -1 && contadorVideojuegos == -1) {
                        JOptionPane.showMessageDialog(null, " Usted no puede usar éste apartado,\n NO SE DIERON DE ALTA, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                    } else {
                        catalogo = JOptionPane.showOptionDialog(null, "¿QUÉ CATÁLOGO DESEA VER?", "CATÁLOGO", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"PELICULAS", "SERIES", "VIDEOJUEGOS"}, null);

                        switch (catalogo) {
                            case 0:
                                if (contadorPelicula != -1) {
                                    for (int i = 0; i <= contadorPelicula; i++) {
                                        PELI[i].mostrarAlta();
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, " Usted no puede usar éste apartado,\n NO SE DIERON DE ALTA PELICULAS, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                                }
                                break;
                            case 1:
                                if (contadorSerie != -1) {
                                    for (int i = 0; i <= contadorSerie; i++) {
                                        SERIE[i].mostrarAlta();
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, " Usted no puede usar éste apartado,\n NO SE DIERON DE ALTA SERIES, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                                }
                                break;
                            case 2:
                                if (contadorVideojuegos != -1) {
                                    for (int i = 0; i <= contadorVideojuegos; i++) {
                                        VIDEOGAMES[i].mostrarAlta();
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, " Usted no puede usar éste apartado,\n NO SE DIERON DE ALTA VIDEOJUEGOS, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                                }
                                break;
                        }
                    }
                    break;

                //RENTA
                case 1:
                    renta = JOptionPane.showOptionDialog(null, "¿QUÉ DESEA RENTAR?", "RENTA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"PELICULAS", "SERIES", "VIDEOJUEGOS"}, null);

                    switch (renta) {
                        //PELICULAS
                        case 0:

                            if (contadorPelicula != -1) {

                                do {
                                    peli = JOptionPane.showInputDialog(null, "¿Cómo se llama la pelicula que desea rentar?", "RENTA", 3);
                                    if (peli.equals("") || peli.equalsIgnoreCase("rentada")) {
                                        JOptionPane.showMessageDialog(null, "Usted dejo el espacio vacio\n Le pedimos de favor, que ingrese el nombre\n Lamentamos las molestias", "ERROR", 2);
                                    }
                                } while (peli.equals("") || peli.equalsIgnoreCase("rentada"));

                                p = false;

                                for (int i = 0; i <= contadorPelicula; i++) {
                                    if (PELI[i] instanceof Peliculas) {
                                        if (PELI[i].nombre.equalsIgnoreCase(peli)) {
                                            p = true;
                                            pBuena = i;
                                        }
                                    }
                                }

                                if (cont != -1) {
                                    for (int i = 0; i < cuantos; i++) {
                                        if (RENTAS[i] instanceof Peliculas) {
                                            if (RENTAS[i].nombre.equalsIgnoreCase(peli)) {
                                                JOptionPane.showMessageDialog(null, "ÉSTA PELICULA, NO SE ENCUENTRA ACTUALMENTE,\n Se encuentra en estado de Renta\n Se le rentó a: " + RENTAS[i].propietario + "\n Con el NIP: " + RENTAS[i].nip + "\n LLEGARÁ EN: " + RENTAS[i].diaFin + "  días");
                                                break;
                                            }
                                        }
                                    }
                                }

                                if (p == false) {
                                    JOptionPane.showMessageDialog(null, "Ésta pelicula no se encuentra en la base de datos,\n Lo invitamos a observar el catálogo para que escoga la pelicula correcta\n ¡¡ LAMENTAMOS LAS MOLESTIAS !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    cont++;

                                    calidad = PELI[pBuena].calidad;
                                    director = PELI[pBuena].director;
                                    duracion = PELI[pBuena].duracion;
                                    clasificacion = PELI[pBuena].clasificacion;
                                    genero = PELI[pBuena].genero;
                                    nombre = PELI[pBuena].nombre;
                                    lanzamiento = PELI[pBuena].lanzamiento;

                                    PELI[pBuena].nombre = "RENTADA";

                                    do {
                                        propietario = JOptionPane.showInputDialog(null, "Nombre de a quién se le renta:", "Ingreso de Datos", 3);
                                        if (propietario.equals("")) {
                                            JOptionPane.showMessageDialog(null, "Usted dejo el espacio vacio\n Le pedimos de favor, que ingrese un dato\n Lamentamos las molestias", "ERROR", 2);
                                        }
                                    } while (propietario.equals(""));

                                    if (cont != 0) {
                                        for (int i = 0; i < cuantos; i++) {
                                            if (RENTAS[i].propietario.equalsIgnoreCase(propietario)) {
                                                JOptionPane.showMessageDialog(null, "ÉSTE CLIENTE NO PUEDE RENTAR OTRA COSA,\n CUENTA CON UN OBJETO QUE LE FALTA DEVOLVER\n LAMENTAMOS LAS MOLESTIAS", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                break;
                                            }
                                        }
                                    }

                                    mesInicio = (String) JOptionPane.showInputDialog(null, "MES EN QUE SE LA LLEVA", "FECHA DE SALIDA", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"}, "SELECCIONE UNA OPCIÓN");

                                    switch (mesInicio) {
                                        case "FEBRERO":
                                            diaInicio = (String) JOptionPane.showInputDialog(null, "DIA DE SALIDA", "FECHA DE SALIDA", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"}, "SELECCIONE UN DIA");
                                            break;
                                        case "ABRIL":
                                        case "JUNIO":
                                        case "SEPTIEMBRE":
                                        case "NOVIEMBRE":
                                            diaInicio = (String) JOptionPane.showInputDialog(null, "DIA DE SALIDA", "FECHA DE SALIDA", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}, "SELECCIONE UN DIA");
                                            break;
                                        case "ENERO":
                                        case "MARZO":
                                        case "MAYO":
                                        case "JULIO":
                                        case "AGOSTO":
                                        case "OCTUBRE":
                                        case "DICIEMBRE":
                                            diaInicio = (String) JOptionPane.showInputDialog(null, "DIA DE SALIDA", "FECHA DE SALIDA", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}, "SELECCIONE UN DIA");
                                            break;
                                    }

                                    do {
                                        añoInicio = Integer.parseInt(JOptionPane.showInputDialog(null, "Año en que se la lleva:", "FECHA DE SALIDA", 3));
                                        if (añoInicio > 2016 || añoInicio < 1500 || añoInicio < lanzamiento) {
                                            JOptionPane.showMessageDialog(null, "Ingreso un año erróneo\n Le pedimos de favor, que ingrese un año correcto\n Lamentamos las molestias", "ERROR", 2);

                                            if (añoInicio < 1500) {
                                                JOptionPane.showMessageDialog(null, "Usted ingreso una fecha menor a 1500\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
                                            } else {
                                                if (añoInicio > 2016) {
                                                    JOptionPane.showMessageDialog(null, "Usted ingreso una fecha mayor a 2016\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
                                                } else {
                                                    if (añoInicio < lanzamiento) {
                                                        JOptionPane.showMessageDialog(null, "No  puede ingresar una fecha de salida menor a la del lanzamiento de la Pelicula\n Le pedimos de favor, que ingrese un año correcto\n Lamentamos las molestias", "ERROR", 2);
                                                    }
                                                }
                                            }
                                        }
                                    } while (añoInicio > 2016 || añoInicio < 1500 || añoInicio < lanzamiento);

                                    nip = aleatorio.nextInt(1000000);
                                    JOptionPane.showMessageDialog(null, "El precio por día es de $ 7.50 pesos\n Por cada día de más será $ 2.50 pesos", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                                    diaFin = (String) JOptionPane.showInputDialog(null, "¿Cuántos días se le prestará?", "FECHA DE ENTREGA", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}, "SELECCIONE UN DIA");
                                    numero = Byte.parseByte(diaFin);
                                    precio = numero * 7.5f;

                                    RENTAS[cont] = new Peliculas(nombre, pBuena, nip, propietario, diaFin);
                                    VISION[cont] = new Peliculas(calidad, director, duracion, clasificacion, genero, nombre, propietario, nip, añoInicio, lanzamiento, diaInicio, diaFin, mesInicio, precio);
                                    pel++;
                                    if (VISION[cont] instanceof Peliculas) {
                                        VISION[cont].mostrar();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, " Usted no puede usar éste apartado,\n NO SE DIERON DE ALTA PELICULAS, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                            }
                            break;

                        //SERIES
                        case 1:

                            if (contadorSerie != -1) {

                                do {
                                    serie = JOptionPane.showInputDialog(null, "¿Cómo se llama la Serie que desea rentar?", "RENTA", 3);
                                    if (serie.equals("") || serie.equalsIgnoreCase("rentada")) {
                                        JOptionPane.showMessageDialog(null, "Usted dejo el espacio vacio\n Le pedimos de favor, que ingrese el nombre\n Lamentamos las molestias", "ERROR", 2);
                                    }
                                } while (serie.equals("") || serie.equalsIgnoreCase("rentada"));

                                s = false;

                                for (int i = 0; i <= contadorPelicula; i++) {
                                    if (SERIE[i] instanceof Series) {
                                        if (SERIE[i].nombre.equalsIgnoreCase(serie)) {
                                            s = true;
                                            sBuena = i;
                                        }
                                    }
                                }

                                if (cont != -1) {
                                    for (int i = 0; i < cuantos; i++) {
                                        if (RENTAS[i].nombre.equalsIgnoreCase(peli)) {
                                            JOptionPane.showMessageDialog(null, "ÉSTA SERIE, NO SE ENCUENTRA ACTUALMENTE,\n Se encuentra en estado de Renta\n Se le rentó a: " + RENTAS[i].propietario + "\n Con el NIP: " + RENTAS[i].nip + "\n LLEGARÁ EN " + RENTAS[i].diaFin + " días");
                                            break;
                                        }
                                    }
                                }

                                if (s == false) {
                                    JOptionPane.showMessageDialog(null, "Ésta Serie no se encuentra en la base de datos,\n Lo invitamos a observar el catálogo para que escoga la pelicula correcta\n ¡¡ LAMENTAMOS LAS MOLESTIAS !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    cont++;

                                    nombre = SERIE[sBuena].nombre;
                                    discos = SERIE[sBuena].discos;
                                    genero = SERIE[sBuena].genero;
                                    clasificacion = SERIE[sBuena].clasificacion;
                                    director = SERIE[sBuena].director;
                                    temporada = SERIE[sBuena].temporada;
                                    lanzamiento = SERIE[sBuena].lanzamiento;

                                    SERIE[sBuena].nombre = "RENTADA";

                                    do {
                                        propietario = JOptionPane.showInputDialog(null, "Nombre de a quién se le renta:", "Ingreso de Datos", 3);
                                        if (propietario.equals("")) {
                                            JOptionPane.showMessageDialog(null, "Usted dejo el espacio vacio\n Le pedimos de favor, que ingrese un dato\n Lamentamos las molestias", "ERROR", 2);
                                        }
                                    } while (propietario.equals(""));

                                    if (cont != 0) {
                                        for (int i = 0; i < cuantos; i++) {
                                            if (RENTAS[i].propietario.equalsIgnoreCase(propietario)) {
                                                JOptionPane.showMessageDialog(null, "ÉSTE CLIENTE NO PUEDE RENTAR OTRA COSA,\n CUENTA CON UN OBJETO QUE LE FALTA DEVOLVER\n LAMENTAMOS LAS MOLESTIAS", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                break;
                                            }
                                        }
                                    }

                                    mesInicio = (String) JOptionPane.showInputDialog(null, "MES EN QUE SE LA LLEVA", "FECHA DE SALIDA", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"}, "SELECCIONE UNA OPCIÓN");

                                    switch (mesInicio) {
                                        case "FEBRERO":
                                            diaInicio = (String) JOptionPane.showInputDialog(null, "DIA DE SALIDA", "FECHA DE SALIDA", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"}, "SELECCIONE UN DIA");
                                            break;
                                        case "ABRIL":
                                        case "JUNIO":
                                        case "SEPTIEMBRE":
                                        case "NOVIEMBRE":
                                            diaInicio = (String) JOptionPane.showInputDialog(null, "DIA DE SALIDA", "FECHA DE SALIDA", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}, "SELECCIONE UN DIA");
                                            break;
                                        case "ENERO":
                                        case "MARZO":
                                        case "MAYO":
                                        case "JULIO":
                                        case "AGOSTO":
                                        case "OCTUBRE":
                                        case "DICIEMBRE":
                                            diaInicio = (String) JOptionPane.showInputDialog(null, "DIA DE SALIDA", "FECHA DE SALIDA", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}, "SELECCIONE UN DIA");
                                            break;
                                    }

                                    do {
                                        añoInicio = Integer.parseInt(JOptionPane.showInputDialog(null, "Año en que se la lleva:", "FECHA DE SALIDA", 3));
                                        if (añoInicio > 2016 || añoInicio < 1500 || añoInicio < lanzamiento) {
                                            JOptionPane.showMessageDialog(null, "Ingreso un año erróneo\n Le pedimos de favor, que ingrese un año correcto\n Lamentamos las molestias", "ERROR", 2);

                                            if (añoInicio < 1500) {
                                                JOptionPane.showMessageDialog(null, "Usted ingreso una fecha menor a 1500\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
                                            } else {
                                                if (añoInicio > 2016) {
                                                    JOptionPane.showMessageDialog(null, "Usted ingreso una fecha mayor a 2016\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
                                                } else {
                                                    if (añoInicio < lanzamiento) {
                                                        JOptionPane.showMessageDialog(null, "No  puede ingresar una fecha de salida menor a la del lanzamiento de la Serie\n Le pedimos de favor, que ingrese un año correcto\n Lamentamos las molestias", "ERROR", 2);
                                                    }
                                                }
                                            }
                                        }
                                    } while (añoInicio > 2016 || añoInicio < 1500 || añoInicio < lanzamiento);

                                    nip = aleatorio.nextInt(1000000);
                                    JOptionPane.showMessageDialog(null, "El precio por día es de $ 10.00 pesos\n Por cada día de más será $ 3.00 pesos", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                                    diaFin = (String) JOptionPane.showInputDialog(null, "¿Cuántos días se le prestará?", "FECHA DE ENTREGA", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}, "SELECCIONE UN DIA");
                                    numero = Byte.parseByte(diaFin);
                                    precio = numero * 10f;

                                    RENTAS[cont] = new Series(nombre, sBuena, nip, propietario, diaFin);
                                    VISION[cont] = new Series(discos, temporada, director, clasificacion, genero, nombre, propietario, nip, añoInicio, lanzamiento, diaInicio, diaFin, mesInicio, precio);
                                    ser++;
                                    if (VISION[cont] instanceof Series) {
                                        VISION[cont].mostrar();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, " Usted no puede usar éste apartado,\n NO SE DIERON DE ALTA SERIES, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                            }

                            break;

                        //VIDEOJUEGOS
                        case 2:
                            if (contadorVideojuegos != -1) {
                                do {
                                    videojuego = JOptionPane.showInputDialog(null, "¿Cómo se llama el Videojuego que desea rentar?", "RENTA", 3);
                                    if (videojuego.equals("") || videojuego.equalsIgnoreCase("rentada")) {
                                        JOptionPane.showMessageDialog(null, "Usted dejo el espacio vacio\n Le pedimos de favor, que ingrese el nombre\n Lamentamos las molestias", "ERROR", 2);
                                    }
                                } while (videojuego.equals("") || videojuego.equalsIgnoreCase("rentada"));

                                v = false;

                                for (int i = 0; i <= contadorVideojuegos; i++) {
                                    if (VIDEOGAMES[i] instanceof Videojuegos) {
                                        if (VIDEOGAMES[i].nombre.equalsIgnoreCase(videojuego)) {
                                            v = true;
                                            vBuena = i;
                                        }
                                    }
                                }

                                if (cont != -1) {
                                    for (int i = 0; i < cuantos; i++) {
                                        if (RENTAS[i].nombre.equalsIgnoreCase(peli)) {
                                            JOptionPane.showMessageDialog(null, "ÉSTE VIDEOJUEGO, NO SE ENCUENTRA ACTUALMENTE,\n Se encuentra en estado de Renta\n Se le rentó a: " + RENTAS[i].propietario + "\n Con el NIP: " + RENTAS[i].nip + "\n LLEGARÁ EN " + RENTAS[i].diaFin + " días");
                                            break;
                                        }
                                    }
                                }

                                if (v == false) {
                                    JOptionPane.showMessageDialog(null, "Éste Videojuego no se encuentra en la base de datos,\n Lo invitamos a observar el catálogo para que escoga la pelicula correcta\n ¡¡ LAMENTAMOS LAS MOLESTIAS !!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    cont++;

                                    plataforma = VIDEOGAMES[vBuena].plataforma;
                                    clasificacion = VIDEOGAMES[vBuena].clasificacion;
                                    nombre = VIDEOGAMES[vBuena].nombre;
                                    genero = VIDEOGAMES[vBuena].genero;
                                    lanzamiento = VIDEOGAMES[vBuena].lanzamiento;

                                    VIDEOGAMES[sBuena].nombre = "RENTADA";

                                    do {
                                        propietario = JOptionPane.showInputDialog(null, "Nombre de a quién se le renta:", "Ingreso de Datos", 3);
                                        if (propietario.equals("")) {
                                            JOptionPane.showMessageDialog(null, "Usted dejo el espacio vacio\n Le pedimos de favor, que ingrese un dato\n Lamentamos las molestias", "ERROR", 2);
                                        }
                                    } while (propietario.equals(""));

                                    if (cont != 0) {
                                        for (int i = 0; i < cuantos; i++) {
                                            if (RENTAS[i].propietario.equalsIgnoreCase(propietario)) {
                                                JOptionPane.showMessageDialog(null, "ÉSTE CLIENTE NO PUEDE RENTAR OTRA COSA,\n CUENTA CON UN OBJETO QUE LE FALTA DEVOLVER\n LAMENTAMOS LAS MOLESTIAS", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                break;
                                            }
                                        }
                                    }

                                    mesInicio = (String) JOptionPane.showInputDialog(null, "MES EN QUE SE LA LLEVA", "FECHA DE SALIDA", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"}, "SELECCIONE UNA OPCIÓN");

                                    switch (mesInicio) {
                                        case "FEBRERO":
                                            diaInicio = (String) JOptionPane.showInputDialog(null, "DIA DE SALIDA", "FECHA DE SALIDA", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"}, "SELECCIONE UN DIA");
                                            break;
                                        case "ABRIL":
                                        case "JUNIO":
                                        case "SEPTIEMBRE":
                                        case "NOVIEMBRE":
                                            diaInicio = (String) JOptionPane.showInputDialog(null, "DIA DE SALIDA", "FECHA DE SALIDA", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}, "SELECCIONE UN DIA");
                                            break;
                                        case "ENERO":
                                        case "MARZO":
                                        case "MAYO":
                                        case "JULIO":
                                        case "AGOSTO":
                                        case "OCTUBRE":
                                        case "DICIEMBRE":
                                            diaInicio = (String) JOptionPane.showInputDialog(null, "DIA DE SALIDA", "FECHA DE SALIDA", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}, "SELECCIONE UN DIA");
                                            break;
                                    }

                                    do {
                                        añoInicio = Integer.parseInt(JOptionPane.showInputDialog(null, "Año en que se la lleva:", "FECHA DE SALIDA", 3));
                                        if (añoInicio > 2016 || añoInicio < 1500 || añoInicio < lanzamiento) {
                                            JOptionPane.showMessageDialog(null, "Ingreso un año erróneo\n Le pedimos de favor, que ingrese un año correcto\n Lamentamos las molestias", "ERROR", 2);

                                            if (añoInicio < 1500) {
                                                JOptionPane.showMessageDialog(null, "Usted ingreso una fecha menor a 1500\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
                                            } else {
                                                if (añoInicio > 2016) {
                                                    JOptionPane.showMessageDialog(null, "Usted ingreso una fecha mayor a 2016\n Le pedimos de favor, que ingrese un dato correcto\n Lamentamos las molestias", "ERROR", 2);
                                                } else {
                                                    if (añoInicio < lanzamiento) {
                                                        JOptionPane.showMessageDialog(null, "No  puede ingresar una fecha de salida menor a la del lanzamiento del Videojuego\n Le pedimos de favor, que ingrese un año correcto\n Lamentamos las molestias", "ERROR", 2);
                                                    }
                                                }
                                            }
                                        }
                                    } while (añoInicio > 2016 || añoInicio < 1500 || añoInicio < lanzamiento);

                                    nip = aleatorio.nextInt(1000000);
                                    JOptionPane.showMessageDialog(null, "El precio por día es de $ 15.00 pesos\n Por cada día de más será $ 5.00 pesos", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                                    diaFin = (String) JOptionPane.showInputDialog(null, "¿Cuántos días se le prestará?", "FECHA DE ENTREGA", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}, "SELECCIONE UN DIA");
                                    numero = Byte.parseByte(diaFin);
                                    precio = numero * 15f;

                                    RENTAS[cont] = new Videojuegos(nombre, vBuena, nip, propietario, diaFin);
                                    VISION[cont] = new Videojuegos(plataforma, clasificacion, genero, nombre, propietario, nip, añoInicio, lanzamiento, diaInicio, diaFin, mesInicio, precio);
                                    vide++;
                                    if (VISION[cont] instanceof Videojuegos) {
                                        VISION[cont].mostrar();
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, " Usted no puede usar éste apartado,\n NO SE DIERON DE ALTA SERIES, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                            }
                            break;
                    }
                    break;

                //DEVOLUCION
                case 2:
                    if (contadorPelicula == -1 && contadorSerie == -1 && contadorVideojuegos == -1) {
                        JOptionPane.showMessageDialog(null, " Usted no puede usar éste apartado,\n NO SE DIERON DE ALTA, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                    } else {
                        if (cont == -1) {
                            JOptionPane.showMessageDialog(null, " Usted no puede usar éste apartado,\n NO SE HAN REALIZADO RENTAS, \n Lo invitamos a realizarlas en el Menú Principal\n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                        } else {
                            devolucion = JOptionPane.showOptionDialog(null, "¿QUÉ VA A DEVOLVER?", "DEVOLUCIÓN", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"PELICULAS", "SERIES", "VIDEOJUEGOS"}, null);

                            switch (devolucion) {
                                //PELICULAS
                                case 0:
                                    if (pel != -1) {

                                        opcionDevolucion = JOptionPane.showOptionDialog(null, "¿CÓMO LO VA A DEVOLVER?", "DEVOLUCIÓN", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"NOMBRE DE LA PELICULA", "NOMBRE DE LA PERSONA", "NIP DEL MOVIMIENTO"}, null);

                                        switch (opcionDevolucion) {
                                            //NOMBRE PELICULA
                                            case 0:

                                                do {
                                                    peliculaDevolucion = JOptionPane.showInputDialog(null, "¿Cómo se llama la pelicula que va a devolver?", "DEVOLUCIÓN", 3);
                                                    if (peliculaDevolucion.equals("") || peliculaDevolucion.equalsIgnoreCase("rentada")) {
                                                        JOptionPane.showMessageDialog(null, "Usted dejo el espacio vacio\n Le pedimos de favor, que ingrese el nombre\n Lamentamos las molestias", "ERROR", 2);
                                                    }
                                                } while (peliculaDevolucion.equals("") || peliculaDevolucion.equalsIgnoreCase("rentada"));

                                                p = false;
                                                for (int i = 0; i <= contadorPelicula; i++) {
                                                    if (RENTAS[i] instanceof Peliculas) {
                                                        if (RENTAS[i].nombre.equalsIgnoreCase(peliculaDevolucion)) {

                                                            entrega = Byte.parseByte(JOptionPane.showInputDialog(null, "¿Cuántos días duró en llevar la pelicula?", "DEVOLUCION", JOptionPane.QUESTION_MESSAGE));
                                                            numero = Byte.parseByte(RENTAS[i].diaFin);

                                                            if (entrega < numero) {
                                                                JOptionPane.showMessageDialog(null, "SE TE HARÁ UN DESCUENTO DEL 10% POR TU PRONTA ENTREGA", "FELICITACIÓN", JOptionPane.INFORMATION_MESSAGE);
                                                                diferenciaDias = numero - entrega;
                                                                precio = (float) ((7.5 * diferenciaDias) - (7.5 * diferenciaDias * 0.10));
                                                            } else {
                                                                if (entrega == numero) {
                                                                    precio = (float) 7.5 * numero;
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "SE TE COBRARÁ $ 2.50 POR CADA DÍA ATRASADO", "ATRASO", JOptionPane.INFORMATION_MESSAGE);
                                                                    diferenciaDias = entrega - numero;
                                                                    extra = (float) (diferenciaDias * 2.50);
                                                                    precio = (float) ((7.5 * numero) + extra);
                                                                }

                                                            }

                                                            PELI[i].mostrarDevolucion(precio);
                                                            p = true;
                                                            encontrar = RENTAS[i].encontrar;
                                                            PELI[encontrar].nombre = RENTAS[i].nombre;
                                                            RENTAS[i].nombre = "";
                                                            RENTAS[i].propietario = "";
                                                            break;
                                                        }
                                                    }
                                                }

                                                if (p == false) {
                                                    JOptionPane.showMessageDialog(null, "El objeto que busca no está en estado actual de Renta,\n ¡¡ LAMENTAMOS LOS INCONVENIENTES", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                }

                                                break;

                                            //NOMBRE DE LA PERSONA
                                            case 1:
                                                do {
                                                    peliculaDevolucion = JOptionPane.showInputDialog(null, "¿Cómo se llama la persona que lo rento?", "DEVOLUCIÓN", 3);
                                                    if (peliculaDevolucion.equals("") || peliculaDevolucion.equalsIgnoreCase("rentada")) {
                                                        JOptionPane.showMessageDialog(null, "Usted dejo el espacio vacio\n Le pedimos de favor, que ingrese el nombre\n Lamentamos las molestias", "ERROR", 2);
                                                    }
                                                } while (peliculaDevolucion.equals("") || peliculaDevolucion.equalsIgnoreCase("rentada"));

                                                p = false;
                                                for (int i = 0; i <= contadorPelicula; i++) {
                                                    if (RENTAS[i] instanceof Peliculas) {
                                                        if (RENTAS[i].propietario.equalsIgnoreCase(peliculaDevolucion)) {

                                                            entrega = Byte.parseByte(JOptionPane.showInputDialog(null, "¿Cuántos días duró en llevar la pelicula?", "DEVOLUCION", JOptionPane.QUESTION_MESSAGE));
                                                            numero = Byte.parseByte(RENTAS[i].diaFin);

                                                            if (entrega < numero) {
                                                                JOptionPane.showMessageDialog(null, "SE TE HARÁ UN DESCUENTO DEL 10% POR TU PRONTA ENTREGA", "FELICITACIÓN", JOptionPane.INFORMATION_MESSAGE);
                                                                diferenciaDias = numero - entrega;
                                                                precio = (float) ((7.5 * diferenciaDias) - (7.5 * diferenciaDias * 0.10));
                                                            } else {
                                                                if (entrega == numero) {
                                                                    precio = (float) 7.5 * numero;
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "SE TE COBRARÁ $ 2.50 POR CADA DÍA ATRASADO", "ATRASO", JOptionPane.INFORMATION_MESSAGE);
                                                                    diferenciaDias = entrega - numero;
                                                                    extra = (float) (diferenciaDias * 2.50);
                                                                    precio = (float) ((7.5 * numero) + extra);
                                                                }

                                                            }

                                                            PELI[i].mostrarDevolucion(precio);
                                                            p = true;
                                                            encontrar = RENTAS[i].encontrar;
                                                            PELI[encontrar].nombre = RENTAS[i].nombre;
                                                            RENTAS[i].nombre = "";
                                                            RENTAS[i].propietario = "";
                                                            break;
                                                        }
                                                    }
                                                }

                                                if (p == false) {
                                                    JOptionPane.showMessageDialog(null, "El objeto que busca no está en estado actual de Renta,\n ¡¡ LAMENTAMOS LOS INCONVENIENTES", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                }

                                                break;

                                            //NIP
                                            case 2:
                                                peliculaNipDevolucion = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuál fue el NIP del movimiento?", "DEVOLUCIÓN", 3));

                                                p = false;
                                                for (int i = 0; i <= contadorPelicula; i++) {
                                                    if (RENTAS[i] instanceof Peliculas) {
                                                        if (RENTAS[i].nip == peliculaNipDevolucion) {

                                                            entrega = Byte.parseByte(JOptionPane.showInputDialog(null, "¿Cuántos días duró en llevar la pelicula?", "DEVOLUCION", JOptionPane.QUESTION_MESSAGE));
                                                            numero = Byte.parseByte(RENTAS[i].diaFin);

                                                            if (entrega < numero) {
                                                                JOptionPane.showMessageDialog(null, "SE TE HARÁ UN DESCUENTO DEL 10% POR TU PRONTA ENTREGA", "FELICITACIÓN", JOptionPane.INFORMATION_MESSAGE);
                                                                diferenciaDias = numero - entrega;
                                                                precio = (float) ((7.5 * diferenciaDias) - (7.5 * diferenciaDias * 0.10));
                                                            } else {
                                                                if (entrega == numero) {
                                                                    precio = (float) 7.5 * numero;
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "SE TE COBRARÁ $ 2.50 POR CADA DÍA ATRASADO", "ATRASO", JOptionPane.INFORMATION_MESSAGE);
                                                                    diferenciaDias = entrega - numero;
                                                                    extra = (float) (diferenciaDias * 2.50);
                                                                    precio = (float) ((7.5 * numero) + extra);
                                                                }

                                                            }

                                                            PELI[i].mostrarDevolucion(precio);
                                                            p = true;
                                                            encontrar = RENTAS[i].encontrar;
                                                            PELI[encontrar].nombre = RENTAS[i].nombre;
                                                            RENTAS[i].nombre = "";
                                                            RENTAS[i].propietario = "";
                                                            break;
                                                        }
                                                    }
                                                }
                                                if (p == false) {
                                                    JOptionPane.showMessageDialog(null, "El objeto que busca no está en estado actual de Renta,\n ¡¡ LAMENTAMOS LOS INCONVENIENTES", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                }

                                                break;
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, " Usted no puede usar éste apartado,\n NO SE HAN HECHO RENTAS DE PELICULAS, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                                    }
                                    break;

                                //SERIES
                                case 1:

                                    if (ser != -1) {

                                        opcionDevolucion = JOptionPane.showOptionDialog(null, "¿CÓMO LO VA A DEVOLVER?", "DEVOLUCIÓN", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"NOMBRE DE LA PELICULA", "NOMBRE DE LA PERSONA", "NIP DEL MOVIMIENTO"}, null);

                                        switch (opcionDevolucion) {
                                            //NOMBRE SERIE
                                            case 0:

                                                do {
                                                    serieDevolucion = JOptionPane.showInputDialog(null, "¿Cómo se llama la serie que va a devolver?", "DEVOLUCIÓN", 3);
                                                    if (serieDevolucion.equals("") || serieDevolucion.equalsIgnoreCase("rentada")) {
                                                        JOptionPane.showMessageDialog(null, "Usted dejo el espacio vacio\n Le pedimos de favor, que ingrese el nombre\n Lamentamos las molestias", "ERROR", 2);
                                                    }
                                                } while (serieDevolucion.equals("") || serieDevolucion.equalsIgnoreCase("rentada"));

                                                s = false;
                                                for (int i = 0; i <= contadorSerie; i++) {
                                                    if (RENTAS[i] instanceof Series) {
                                                        if (RENTAS[i].nombre.equalsIgnoreCase(serieDevolucion)) {

                                                            entrega = Byte.parseByte(JOptionPane.showInputDialog(null, "¿Cuántos días duró en llevar la pelicula?", "DEVOLUCION", JOptionPane.QUESTION_MESSAGE));
                                                            numero = Byte.parseByte(RENTAS[i].diaFin);

                                                            if (entrega < numero) {
                                                                JOptionPane.showMessageDialog(null, "SE TE HARÁ UN DESCUENTO DEL 10% POR TU PRONTA ENTREGA", "FELICITACIÓN", JOptionPane.INFORMATION_MESSAGE);
                                                                diferenciaDias = numero - entrega;
                                                                precio = (float) ((10 * diferenciaDias) - (10 * diferenciaDias * 0.10));
                                                            } else {
                                                                if (entrega == numero) {
                                                                    precio = (float) 10 * numero;
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "SE TE COBRARÁ $ 2.50 POR CADA DÍA ATRASADO", "ATRASO", JOptionPane.INFORMATION_MESSAGE);
                                                                    diferenciaDias = entrega - numero;
                                                                    extra = (float) (diferenciaDias * 3);
                                                                    precio = (float) ((10 * numero) + extra);
                                                                }

                                                            }

                                                            SERIE[i].mostrarDevolucion(precio);
                                                            s = true;
                                                            encontrar = RENTAS[i].encontrar;
                                                            SERIE[encontrar].nombre = RENTAS[i].nombre;
                                                            RENTAS[i].nombre = "";
                                                            RENTAS[i].propietario = "";
                                                            break;
                                                        }
                                                    }
                                                }

                                                if (s == false) {
                                                    JOptionPane.showMessageDialog(null, "El objeto que busca no está en estado actual de Renta,\n ¡¡ LAMENTAMOS LOS INCONVENIENTES", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                }

                                                break;

                                            //NOMBRE DE LA PERSONA
                                            case 1:
                                                do {
                                                    serieDevolucion = JOptionPane.showInputDialog(null, "¿Cómo se llama la persona que la devolvió?", "DEVOLUCIÓN", 3);
                                                    if (serieDevolucion.equals("") || serieDevolucion.equalsIgnoreCase("rentada")) {
                                                        JOptionPane.showMessageDialog(null, "Usted dejo el espacio vacio\n Le pedimos de favor, que ingrese el nombre\n Lamentamos las molestias", "ERROR", 2);
                                                    }
                                                } while (serieDevolucion.equals("") || serieDevolucion.equalsIgnoreCase("rentada"));

                                                s = false;
                                                for (int i = 0; i <= contadorSerie; i++) {
                                                    if (RENTAS[i] instanceof Series) {
                                                        if (RENTAS[i].nombre.equalsIgnoreCase(serieDevolucion)) {

                                                            entrega = Byte.parseByte(JOptionPane.showInputDialog(null, "¿Cuántos días duró en llevar la pelicula?", "DEVOLUCION", JOptionPane.QUESTION_MESSAGE));
                                                            numero = Byte.parseByte(RENTAS[i].diaFin);

                                                            if (entrega < numero) {
                                                                JOptionPane.showMessageDialog(null, "SE TE HARÁ UN DESCUENTO DEL 10% POR TU PRONTA ENTREGA", "FELICITACIÓN", JOptionPane.INFORMATION_MESSAGE);
                                                                diferenciaDias = numero - entrega;
                                                                precio = (float) ((10 * diferenciaDias) - (10 * diferenciaDias * 0.10));
                                                            } else {
                                                                if (entrega == numero) {
                                                                    precio = (float) 10 * numero;
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "SE TE COBRARÁ $ 2.50 POR CADA DÍA ATRASADO", "ATRASO", JOptionPane.INFORMATION_MESSAGE);
                                                                    diferenciaDias = entrega - numero;
                                                                    extra = (float) (diferenciaDias * 3);
                                                                    precio = (float) ((10 * numero) + extra);
                                                                }

                                                            }

                                                            SERIE[i].mostrarDevolucion(precio);
                                                            s = true;
                                                            encontrar = RENTAS[i].encontrar;
                                                            SERIE[encontrar].nombre = RENTAS[i].nombre;
                                                            RENTAS[i].nombre = "";
                                                            RENTAS[i].propietario = "";
                                                            break;
                                                        }
                                                    }
                                                }

                                                if (s == false) {
                                                    JOptionPane.showMessageDialog(null, "El objeto que busca no está en estado actual de Renta,\n ¡¡ LAMENTAMOS LOS INCONVENIENTES", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                }

                                                break;

                                            //NIP
                                            case 2:
                                                serieNipDevolucion = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuál fue el NIP del movimiento?", "DEVOLUCIÓN", 3));

                                                s = false;
                                                for (int i = 0; i <= contadorSerie; i++) {
                                                    if (RENTAS[i] instanceof Series) {
                                                        if (RENTAS[i].nip == serieNipDevolucion) {

                                                            entrega = Byte.parseByte(JOptionPane.showInputDialog(null, "¿Cuántos días duró en llevar la pelicula?", "DEVOLUCION", JOptionPane.QUESTION_MESSAGE));
                                                            numero = Byte.parseByte(RENTAS[i].diaFin);

                                                            if (entrega < numero) {
                                                                JOptionPane.showMessageDialog(null, "SE TE HARÁ UN DESCUENTO DEL 10% POR TU PRONTA ENTREGA", "FELICITACIÓN", JOptionPane.INFORMATION_MESSAGE);
                                                                diferenciaDias = numero - entrega;
                                                                precio = (float) ((10 * diferenciaDias) - (10 * diferenciaDias * 0.10));
                                                            } else {
                                                                if (entrega == numero) {
                                                                    precio = (float) 10 * numero;
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "SE TE COBRARÁ $ 2.50 POR CADA DÍA ATRASADO", "ATRASO", JOptionPane.INFORMATION_MESSAGE);
                                                                    diferenciaDias = entrega - numero;
                                                                    extra = (float) (diferenciaDias * 3);
                                                                    precio = (float) ((10 * numero) + extra);
                                                                }

                                                            }

                                                            SERIE[i].mostrarDevolucion(precio);
                                                            s = true;
                                                            encontrar = RENTAS[i].encontrar;
                                                            SERIE[encontrar].nombre = RENTAS[i].nombre;
                                                            RENTAS[i].nombre = "";
                                                            RENTAS[i].propietario = "";
                                                            break;
                                                        }
                                                    }
                                                }

                                                if (s == false) {
                                                    JOptionPane.showMessageDialog(null, "El objeto que busca no está en estado actual de Renta,\n ¡¡ LAMENTAMOS LOS INCONVENIENTES", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                }

                                                break;
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, " Usted no puede usar éste apartado,\n NO SE HAN HECHO RENTAS DE PELICULAS, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                                    }

                                    break;

                                //VIDEOJUEGOS
                                case 2:

                                    if (vide != -1) {

                                        opcionDevolucion = JOptionPane.showOptionDialog(null, "¿CÓMO LO VA A DEVOLVER?", "DEVOLUCIÓN", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"NOMBRE DE LA PELICULA", "NOMBRE DE LA PERSONA", "NIP DEL MOVIMIENTO"}, null);

                                        switch (opcionDevolucion) {
                                            //NOMBRE VIDEOJUEGO
                                            case 0:

                                                do {
                                                    videojuegosDevolucion = JOptionPane.showInputDialog(null, "¿Cómo se llama el videojuego que va a devolver?", "DEVOLUCIÓN", 3);
                                                    if (videojuegosDevolucion.equals("") || videojuegosDevolucion.equalsIgnoreCase("rentada")) {
                                                        JOptionPane.showMessageDialog(null, "Usted dejo el espacio vacio\n Le pedimos de favor, que ingrese el nombre\n Lamentamos las molestias", "ERROR", 2);
                                                    }
                                                } while (videojuegosDevolucion.equals("") || videojuegosDevolucion.equalsIgnoreCase("rentada"));

                                                v = false;
                                                for (int i = 0; i <= contadorVideojuegos; i++) {
                                                    if (RENTAS[i] instanceof Videojuegos) {
                                                        if (RENTAS[i].nombre.equalsIgnoreCase(videojuegosDevolucion)) {

                                                            entrega = Byte.parseByte(JOptionPane.showInputDialog(null, "¿Cuántos días duró en llevar la pelicula?", "DEVOLUCION", JOptionPane.QUESTION_MESSAGE));
                                                            numero = Byte.parseByte(RENTAS[i].diaFin);

                                                            if (entrega < numero) {
                                                                JOptionPane.showMessageDialog(null, "SE TE HARÁ UN DESCUENTO DEL 10% POR TU PRONTA ENTREGA", "FELICITACIÓN", JOptionPane.INFORMATION_MESSAGE);
                                                                diferenciaDias = numero - entrega;
                                                                precio = (float) ((15 * diferenciaDias) - (15 * diferenciaDias * 0.10));
                                                            } else {
                                                                if (entrega == numero) {
                                                                    precio = (float) 15 * numero;
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "SE TE COBRARÁ $ 2.50 POR CADA DÍA ATRASADO", "ATRASO", JOptionPane.INFORMATION_MESSAGE);
                                                                    diferenciaDias = entrega - numero;
                                                                    extra = (float) (diferenciaDias * 5);
                                                                    precio = (float) ((15 * numero) + extra);
                                                                }

                                                            }

                                                            VIDEOGAMES[i].mostrarDevolucion(precio);
                                                            v = true;
                                                            encontrar = RENTAS[i].encontrar;
                                                            VIDEOGAMES[encontrar].nombre = RENTAS[i].nombre;
                                                            RENTAS[i].nombre = "";
                                                            RENTAS[i].propietario = "";
                                                            break;
                                                        }
                                                    }
                                                }

                                                if (v == false) {
                                                    JOptionPane.showMessageDialog(null, "El objeto que busca no está en estado actual de Renta,\n ¡¡ LAMENTAMOS LOS INCONVENIENTES", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                }

                                                break;

                                            //NOMBRE DEL VIDEOJUEGO
                                            case 1:

                                                do {
                                                    videojuegosDevolucion = JOptionPane.showInputDialog(null, "¿Cómo se llama la persona que va a devolver el videojuego?", "DEVOLUCIÓN", 3);
                                                    if (videojuegosDevolucion.equals("") || videojuegosDevolucion.equalsIgnoreCase("rentada")) {
                                                        JOptionPane.showMessageDialog(null, "Usted dejo el espacio vacio\n Le pedimos de favor, que ingrese el nombre\n Lamentamos las molestias", "ERROR", 2);
                                                    }
                                                } while (videojuegosDevolucion.equals("") || videojuegosDevolucion.equalsIgnoreCase("rentada"));

                                                v = false;
                                                for (int i = 0; i <= contadorVideojuegos; i++) {
                                                    if (RENTAS[i] instanceof Videojuegos) {
                                                        if (RENTAS[i].nombre.equalsIgnoreCase(videojuegosDevolucion)) {

                                                            entrega = Byte.parseByte(JOptionPane.showInputDialog(null, "¿Cuántos días duró en llevar la pelicula?", "DEVOLUCION", JOptionPane.QUESTION_MESSAGE));
                                                            numero = Byte.parseByte(RENTAS[i].diaFin);

                                                            if (entrega < numero) {
                                                                JOptionPane.showMessageDialog(null, "SE TE HARÁ UN DESCUENTO DEL 10% POR TU PRONTA ENTREGA", "FELICITACIÓN", JOptionPane.INFORMATION_MESSAGE);
                                                                diferenciaDias = numero - entrega;
                                                                precio = (float) ((15 * diferenciaDias) - (15 * diferenciaDias * 0.10));
                                                            } else {
                                                                if (entrega == numero) {
                                                                    precio = (float) 15 * numero;
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "SE TE COBRARÁ $ 2.50 POR CADA DÍA ATRASADO", "ATRASO", JOptionPane.INFORMATION_MESSAGE);
                                                                    diferenciaDias = entrega - numero;
                                                                    extra = (float) (diferenciaDias * 5);
                                                                    precio = (float) ((15 * numero) + extra);
                                                                }

                                                            }

                                                            VIDEOGAMES[i].mostrarDevolucion(precio);
                                                            v = true;
                                                            encontrar = RENTAS[i].encontrar;
                                                            VIDEOGAMES[encontrar].nombre = RENTAS[i].nombre;
                                                            RENTAS[i].nombre = "";
                                                            RENTAS[i].propietario = "";
                                                            break;
                                                        }
                                                    }
                                                }

                                                if (v == false) {
                                                    JOptionPane.showMessageDialog(null, "El objeto que busca no está en estado actual de Renta,\n ¡¡ LAMENTAMOS LOS INCONVENIENTES", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                }

                                                break;

                                            //NIP
                                            case 2:
                                                videojuegosNipDevolucion = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuál fue el NIP del movimiento?", "DEVOLUCIÓN", 3));

                                                v = false;
                                                for (int i = 0; i <= contadorVideojuegos; i++) {
                                                    if (RENTAS[i] instanceof Videojuegos) {
                                                        if (RENTAS[i].nip == videojuegosNipDevolucion) {

                                                            entrega = Byte.parseByte(JOptionPane.showInputDialog(null, "¿Cuántos días duró en llevar la pelicula?", "DEVOLUCION", JOptionPane.QUESTION_MESSAGE));
                                                            numero = Byte.parseByte(RENTAS[i].diaFin);

                                                            if (entrega < numero) {
                                                                JOptionPane.showMessageDialog(null, "SE TE HARÁ UN DESCUENTO DEL 10% POR TU PRONTA ENTREGA", "FELICITACIÓN", JOptionPane.INFORMATION_MESSAGE);
                                                                diferenciaDias = numero - entrega;
                                                                precio = (float) ((15 * diferenciaDias) - (15 * diferenciaDias * 0.10));
                                                            } else {
                                                                if (entrega == numero) {
                                                                    precio = (float) 15 * numero;
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "SE TE COBRARÁ $ 2.50 POR CADA DÍA ATRASADO", "ATRASO", JOptionPane.INFORMATION_MESSAGE);
                                                                    diferenciaDias = entrega - numero;
                                                                    extra = (float) (diferenciaDias * 5);
                                                                    precio = (float) ((15 * numero) + extra);
                                                                }

                                                            }

                                                            VIDEOGAMES[i].mostrarDevolucion(precio);
                                                            v = true;
                                                            encontrar = RENTAS[i].encontrar;
                                                            VIDEOGAMES[encontrar].nombre = RENTAS[i].nombre;
                                                            RENTAS[i].nombre = "";
                                                            RENTAS[i].propietario = "";
                                                            break;
                                                        }
                                                    }
                                                }

                                                if (p == false) {
                                                    JOptionPane.showMessageDialog(null, "El objeto que busca no está en estado actual de Renta,\n ¡¡ LAMENTAMOS LOS INCONVENIENTES", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                }

                                                break;
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, " Usted no puede usar éste apartado,\n NO SE HAN HECHO RENTAS DE PELICULAS, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                                    }
                                    break;
                            }
                        }
                    }
                    break;

                //MOSTRAR TODOS
                case 3:
                    if (contadorPelicula == -1 && contadorSerie == -1 && contadorVideojuegos == -1) {
                        JOptionPane.showMessageDialog(null, " Usted no puede usar éste apartado,\n NO SE DIERON DE ALTA, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                    } else {

                        if (contadorPelicula != -1) {
                            for (int i = 0; i <= contadorPelicula; i++) {
                                PELI[i].mostrarAlta();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, " NO EXISTEN PELICULAS,\n NO SE DIERON DE ALTA PELICULAS, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                        }

                        if (contadorSerie != -1) {
                            for (int i = 0; i <= contadorSerie; i++) {
                                SERIE[i].mostrarAlta();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, " NO EXISTEN SERIES,\n NO SE DIERON DE ALTA SERIES, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                        }

                        if (contadorVideojuegos != -1) {
                            for (int i = 0; i <= contadorVideojuegos; i++) {
                                VIDEOGAMES[i].mostrarAlta();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, " NO EXISTEN VIDEOJUEGOS,\n NO SE DIERON DE ALTA VIDEOJUEGOS, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                        }
                    }
                    break;

                //MOSTRAR ESPECIFICO
                case 4:
                    if (contadorPelicula == -1 && contadorSerie == -1 && contadorVideojuegos == -1) {
                        JOptionPane.showMessageDialog(null, " Usted no puede usar éste apartado,\n NO SE DIERON DE ALTA, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                    } else {

                        if (contadorPelicula == -1 && contadorSerie == -1 && contadorVideojuegos == -1) {
                            JOptionPane.showMessageDialog(null, " Usted no puede usar éste apartado,\n NO SE DIERON DE ALTA, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                        } else {
                            especifico = JOptionPane.showOptionDialog(null, "¿CUÁLES DESEA IMPRIMIR?", "MOSTRAR ESPECÍFICO", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"PELICULAS", "SERIES", "VIDEOJUEGOS"}, null);

                            switch (especifico) {
                                case 0:
                                    if (contadorPelicula != -1) {
                                        for (int i = 0; i <= contadorPelicula; i++) {
                                            PELI[i].mostrarAlta();
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, " Usted no puede usar éste apartado,\n NO SE DIERON DE ALTA PELICULAS, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                                    }
                                    break;
                                case 1:
                                    if (contadorSerie != -1) {
                                        for (int i = 0; i <= contadorSerie; i++) {
                                            SERIE[i].mostrarAlta();
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, " Usted no puede usar éste apartado,\n NO SE DIERON DE ALTA SERIES, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                                    }
                                    break;
                                case 2:
                                    if (contadorVideojuegos != -1) {
                                        for (int i = 0; i <= contadorVideojuegos; i++) {
                                            VIDEOGAMES[i].mostrarAlta();
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, " Usted no puede usar éste apartado,\n NO SE DIERON DE ALTA VIDEOJUEGOS, \n LAMENTAMOS LAS MOLESTIAS", "ERROR", 2);
                                    }
                                    break;
                            }
                        }
                        break;
                    }
            }
        } while (opcion != 5);
        JOptionPane.showMessageDialog(null, "GRACIAS POR USAR ÉSTE PROGRAMA\n\t ¡¡Lo esperamos de vuelta muy pronto!!\n Creado por: MARIO JOSUE DEL TORO MORALES", "AGRADECIMIENTO", 1);
    }
}
