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
    
    public static String mensaje( String descripcionMensaje )
    {
        String tipoMensaje = "";
        // TO DO: modificar mensajes
        switch ( descripcionMensaje ) {
            case "El programa ha sido simulado con éxito": tipoMensaje = "Execution";
                break;
            case "Direccionamiento resulta en desalineamiento": tipoMensaje = "Error";
                break;
            case "Dirección prohibida": tipoMensaje = "Error";
                break;
            case "Intrucción no soportada": tipoMensaje = "Error";
                break;
            case "El archivo que se desea simular es muy grande para la memoria disponible"
                    + " o existe una instrucción que viola el formato establecido": tipoMensaje = "Error";
                break;
            default: tipoMensaje = "Error";
                break;
      }
        return "ARMv4@" + tipoMensaje + ":-~$" + " " + descripcionMensaje + "\n";
    }
    
    public static String mensajeAssembly(String message)
    {
        return "ARMv4@" + "Assembly" + ":-~$" + " " + message + "\n";
    }
    
    public static String mensajeExecution(String message)
    {
        return "ARMv4@" + "Execution" + ":-~$" + " " + message + "\n";
    }
    
    public static String showActualPath(String msj)
    {
        return "ARMv4@" + "CurrentFile" + ":-~$" + " " + msj+ "\n";
    }
    
    public static String initMensaje(String msj)
    {
        return "ARMv4@" + "Info" + ":-~$" + " " + msj+ "\n";
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
