package ua.training.controller;

import ua.training.view.View;
import ua.training.model.Model;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by andrii on 09.11.16.
 */
public class Controller {

    /**
     *
     */
    public static String CLASS_FOR_ANALYSIS = "ua.training.model.Vehicle";

    /**
     *
     */
    Model model;

    /**
     *
     */
    View view;

    /**
     * initialize model and view
     * @param model
     * @param view
     */
    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    /**
     *
     */
    public void processUser(){
        try {
            Class clazz = Class.forName(CLASS_FOR_ANALYSIS);
            view.printMessage(model.getConstructorsInfo(clazz));
            view.printMessage(model.getMethodInfo(clazz));
            view.printMessage(model.getDeclaredMethodsInfo(clazz));
            view.printMessage(model.getDeclaredFieldsInfo(clazz));
            view.printMessage(model.getPackage(clazz));
            view.printMessage(model.getSimpleName(clazz));
            ArrayList<Method> methods = model.getAnnotatedMethods(clazz);
            for(Method m : methods) {
                view.printMessage("Invoked " + m.getName() + " " + m.invoke(clazz.newInstance()));
            }
        } catch (Exception e) {

        }
    }


}