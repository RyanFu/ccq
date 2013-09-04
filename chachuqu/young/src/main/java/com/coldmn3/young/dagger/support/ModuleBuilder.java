package com.coldmn3.young.dagger.support;

import java.util.List;
import java.util.ArrayList;
import dagger.ObjectGraph;
import java.lang.annotation.Annotation;

/**
 * Helper class used to build per-test modules.
 */
public class ModuleBuilder {

    public static ObjectGraph build(Object test) throws IllegalAccessException, InstantiationException {
        return ObjectGraph.create(getModules(test));
    }

    private static Object getModules(Object test) throws InstantiationException, IllegalAccessException {
        List<Object> modules = new ArrayList<Object>();
        for (Annotation annotation : test.getClass().getAnnotations()) {
            Using using = (Using) annotation;
            modules.add(using.value().newInstance());
        }

        return modules;
    }
}
