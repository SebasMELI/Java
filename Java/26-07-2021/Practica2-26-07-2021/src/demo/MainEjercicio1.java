package demo;

import password.PasswordFuerte;
import password.PasswordIntermedia;
import password.PasswordSimple;

public class MainEjercicio1 {

    public static void main(String[] args) {
        //Debe de estar formado por minimo 15 letras y un maximo de 50
        PasswordSimple passwordSimple = new PasswordSimple();
        PasswordIntermedia passwordIntermedia = new PasswordIntermedia();
        PasswordFuerte passwordFuerte = new PasswordFuerte();
        passwordSimple.setPassword("Ahkjaflkaare");
        passwordIntermedia.setPassword("Holaestoyenjava123");
        passwordFuerte.setPassword("H014Mund03570y3nJ4v@!!");

        System.out.println("Todo Paso");

    }
}
