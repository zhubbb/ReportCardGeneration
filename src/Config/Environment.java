package Config;

import DB.Storage;

import java.util.HashMap;
import java.util.Map;

public class Environment {
//    public static String courseDataPath;
//    public static String testDataPath;
//    public static String markDataPath;
//    public static String studentDataPath;
    public static String configDataPath;
    public static String splitter;

    public static Storage database;
    public static Map<ParameterType,String> configParameters;

    static{
        splitter=",";
        configParameters = new HashMap<>();
        database = new Storage();
        configDataPath = "Config/config.csv";
    }


    public static enum ParameterType {
        TEST("TEST"), MARK("MARK"), STUDENT("STUDENT"), COURSE("COURSE"),OUTPUT("OUTPUT");
        private final String name;
        private static final Map<String, ParameterType> lookup;
        static {
            lookup= new HashMap<String, ParameterType>();
            for (ParameterType d : ParameterType.values()) {
                lookup.put(d.getName(), d);
            }
        }
        private ParameterType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static ParameterType get(String name) {
            return lookup.get(name);
        }
    }

}
