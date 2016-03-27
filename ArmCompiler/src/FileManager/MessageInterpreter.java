package FileManager;

/**
 *
 * @author Daniel
 */
public class MessageInterpreter {
    
    public MessageInterpreter()
    {
        // TO DO: instanciar la clase de MAU
    }
    
    public static String mensaje()
    {
        String descripcionMensaje = "Ejecución Exitosa";
        String tipoMensaje = "";
        // TO DO: modificar mensajes
        switch ( descripcionMensaje ) {
            case "Ejecución Exitosa": tipoMensaje = "Ejecución";
                break;
            case "-": tipoMensaje = "H";
                break;
            default: tipoMensaje = "ERROR";
                break;
      }
        return "ARMv4@" + tipoMensaje + ":-~$" + " " + descripcionMensaje + "\n";
    }
    
    public static String mensajeAssembly(String message)
    {
        return "ARMv4@" + "Assembly" + ":-~$" + " " + message + "\n";
    }
    
    public static String aboutMessage()
    {
        String msj = "Instituto Tecnológico de Costa Rica\n"
                + "Ingeniería en Computadores\n"
                + "Curso: CE-4301 Arquitectura de Computadores I\n"
                + "Desarrolladores:\n"
                + "           Arturo Salas Delgado\n"
                + "           Daniel Araya Villavicencio\n"
                + "           Mario Monge Huertas\n"
                + "\n"
                + "Copyright (c) 2016 ARDAMA\n" 
                + "All Rights Reserved.\n"
                + "This product is protected by copyright and distributed under\n" 
                + "licenses restricting copying, distribution and decompilation.";
        return msj;
    }
    
}
