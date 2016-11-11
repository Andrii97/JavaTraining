package ua.training.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * Created by andrii on 09.11.16.
 */
public class Model {
    /**
     *
     */
    public static final String CLASS_NAME = "Class name = ";

    /**
     *
     */
    public static final String NAME = " Name: ";

    /**
     *
     */
    public static final String METHODS = " Methods: ";

    /**
     *
     */
    public static final String CONSTRUCTORS = " Constructors: ";

    /**
     *
     */
    public static final String NEW_LINE = "\n";

    /**
     *
     */
    public static final String RETURN_TYPE = " Return type: ";

    /**
     *
     */
    public static final String PARAM_TYPES = " Param types: ";

    /**
     *
     */
    public static final String ANNOTATIONS = " Annotations: ";

    /**
     *
     */
    public static final String PUBLIC = " public ";

    /**
     *
     */
    public static final String PROTECTED = " protected ";

    /**
     *
     */
    public static final String PRIVATE = " private ";

    /**
     *
     */
    public static final String FINAL = " final ";

    /**
     *
     */
    public static final String STATIC = " static ";

    /**
     *
     */
    public static final String ABSTRACT = " abstract ";

    /**
     *
     */
    public static final String TYPE = " type = ";

    /**
     *
     */
    public static final String MODIFIERS = " Modifiers: ";

    /**
     *
     */
    public static final String SUPER_CLASS = " Super class = ";

    /**
     *
     */
    public static final String FIELDS = " Fields ";

    /**
     *
     */
    private StringBuilder resultStringBuilder;

    public Model() {
    }

    /**
     *
     * @param clazz
     * @return
     */
    public String getMethodInfo(Class clazz) {
        resultStringBuilder = new StringBuilder();
        resultStringBuilder.append(CLASS_NAME);
        resultStringBuilder.append(clazz.getName());
        resultStringBuilder.append(NEW_LINE);
        resultStringBuilder.append(METHODS);
        resultStringBuilder.append(NEW_LINE);
        Method[] methods = clazz.getMethods();
        for(Method m : methods) {
            resultStringBuilder.append(NAME);
            resultStringBuilder.append(m.getName());
            resultStringBuilder.append(RETURN_TYPE);
            resultStringBuilder.append(m.getReturnType().getName());
            Class[] paramTypes = m.getParameterTypes();
            resultStringBuilder.append(PARAM_TYPES);
            for (Class paramType : paramTypes) {
                resultStringBuilder.append(" ");
                resultStringBuilder.append(paramType.getName());
            }
            Annotation[] annotations = m.getDeclaredAnnotations();
            if (annotations.length != 0) {
                resultStringBuilder.append(ANNOTATIONS);
            }
            for (Annotation annotation : annotations) {
                resultStringBuilder.append(" ");
                resultStringBuilder.append(annotation.toString());
            }
            resultStringBuilder.append(NEW_LINE);
        }
        return resultStringBuilder.toString();
    }

    /**
     *
     * @param clazz
     * @return
     */
    public String getConstructorsInfo(Class clazz) {
        resultStringBuilder = new StringBuilder();
        resultStringBuilder.append(CLASS_NAME);
        resultStringBuilder.append(clazz.getName());
        resultStringBuilder.append(NEW_LINE);
        resultStringBuilder.append(CONSTRUCTORS);
        resultStringBuilder.append(NEW_LINE);
        Constructor[] constructors = clazz.getConstructors();
        int i = 1;
        for (Constructor constructor : constructors) {
            resultStringBuilder.append("Constructor " + i++);
            resultStringBuilder.append(NEW_LINE);
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class paramType : paramTypes) {
                resultStringBuilder.append(paramType.getName() + ", ");
            }
            resultStringBuilder.append(NEW_LINE);
        }
        return resultStringBuilder.toString();
    }

    /**
     *
     * @param mods
     * @return
     */
    public StringBuilder getModifiers(int mods) {
        StringBuilder result = new StringBuilder();
        if (Modifier.isPublic(mods)) {
            result.append(PUBLIC);
        }
        if (Modifier.isProtected(mods)) {
            result.append(PROTECTED);
        }
        if (Modifier.isPrivate(mods)) {
            result.append(PRIVATE);
        }
        if (Modifier.isStatic(mods)) {
            result.append(STATIC);
        }
        if (Modifier.isAbstract(mods)) {
            result.append(ABSTRACT);
        }
        if (Modifier.isFinal(mods)) {
            result.append(FINAL);
        }
        return result;
    }

    /**
     *
     * @param clazz
     * @return
     */
    public String getDeclaredMethodsInfo(Class clazz) {
        resultStringBuilder = new StringBuilder();
        resultStringBuilder.append(CLASS_NAME);
        resultStringBuilder.append(clazz.getName());
        resultStringBuilder.append(NEW_LINE);
        resultStringBuilder.append(METHODS);
        resultStringBuilder.append(NEW_LINE);
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            resultStringBuilder.append(MODIFIERS);
            resultStringBuilder.append(getModifiers(m.getModifiers()));
            resultStringBuilder.append(NAME);
            resultStringBuilder.append(m.getName());
            resultStringBuilder.append(RETURN_TYPE);
            resultStringBuilder.append(m.getReturnType().getName());
            Class[] paramTypes = m.getParameterTypes();
            resultStringBuilder.append(PARAM_TYPES);
            for (Class paramType : paramTypes) {
                resultStringBuilder.append(" ");
                resultStringBuilder.append(paramType.getName());
            }
            Annotation[] annotations = m.getDeclaredAnnotations();
            if (annotations.length != 0) {
                resultStringBuilder.append(ANNOTATIONS);
            }
            for (Annotation annotation : annotations) {
                resultStringBuilder.append(" ");
                resultStringBuilder.append(annotation.toString());
            }
            resultStringBuilder.append(NEW_LINE);
        }
        return resultStringBuilder.toString();
    }

    /**
     *
     * @param clazz
     * @return
     */
    public String getDeclaredFieldsInfo(Class clazz) {
        resultStringBuilder = new StringBuilder();
        resultStringBuilder.append(CLASS_NAME);
        resultStringBuilder.append(clazz.getName());
        resultStringBuilder.append(NEW_LINE);
        resultStringBuilder.append(FIELDS);
        resultStringBuilder.append(NEW_LINE);
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            resultStringBuilder.append(MODIFIERS);
            int mods = field.getModifiers();
            resultStringBuilder.append(getModifiers(mods));
            resultStringBuilder.append(TYPE);
            resultStringBuilder.append(field.getType().getName());
            resultStringBuilder.append(NAME);
            resultStringBuilder.append(field.getName());
            Annotation[] annotations = field.getDeclaredAnnotations();
            if (annotations.length != 0) {
                resultStringBuilder.append(ANNOTATIONS);
            }
            for (Annotation annotation : annotations) {
                resultStringBuilder.append(" " + annotation.toString());
            }
            resultStringBuilder.append(NEW_LINE);
        }
        return resultStringBuilder.toString();
    }

    /**
     *
     * @param clazz
     * @return
     */
    public String getPackage(Class clazz) {
        return SUPER_CLASS + clazz.getSuperclass();
    }

    /**
     *
     * @param clazz
     * @return
     */
    public String getSimpleName(Class clazz) {
        return NAME + clazz.getSimpleName();
    }

    /**
     *
     * @param clazz
     * @return
     */
    public ArrayList<Method> getAnnotatedMethods(Class clazz) {
        ArrayList<Method> annotatedMethods = new ArrayList<>();
        for(Method m : clazz.getMethods()) {
            AnnotationForMethods annotation = m.getAnnotation(AnnotationForMethods.class);
            if(annotation != null){
                annotatedMethods.add(m);
            }
        }
        return annotatedMethods;
    }
}
