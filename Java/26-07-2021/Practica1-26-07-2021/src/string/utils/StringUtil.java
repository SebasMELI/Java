package string.utils;

public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n){
        String caracteres = "";
        for (int i = 0; i < n; i++)
            caracteres += c;
        return caracteres;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c){
        String caracteres = "";
        for (int i = 0; i < n - 1; i++)
            if ((caracteres + s).length() < n)
                caracteres += c;
        return caracteres += s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[]){
        int arrLength = arr.length;
        String[] caracteres = new String[arrLength];
        for (int i = 0; i < arrLength; i++) {
            caracteres[i] = Integer.toString(arr[i]);
        }
        return caracteres;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[]){
        int arrLength = arr.length;
        int[] caracteres = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            caracteres[i] = Integer.parseInt(arr[i]);
        }
        return caracteres;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[]){
        int longitud = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i].length() > longitud) longitud = arr[i].length();
        return longitud;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[],char c){
        int longitud = maxLength(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = lpad(arr[i], longitud, c);
        }
    }

    public static String rpad(String s,char c,int n){
        String caracteres = s;
        for (int i = 0; i < n - 1; i++)
            if ((caracteres + s).length() < n)
                caracteres += c;
        return caracteres;
    }

    public static String ltrim(String s){
        return s.replaceAll("^\\s*","");
    }

    public static String rtrim(String s){
        return s.replaceAll("\\s*$","");
    }

    public static String trim(String s){
        return s.trim();
    }

    public static int indexOfN(String s,char c,int n){
        char[] caracteres = s.toCharArray();
        int posicion = -1;
        int ocurrencia = 0;

        for (int i = 0; i < caracteres.length; i++) {
            if (caracteres[i] == c) ocurrencia++;
            if (ocurrencia == n) {
                posicion = i;
                    break;
            }
        }
        
        return posicion;
    }
}