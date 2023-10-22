package noushin.core.library;


/**
 * A Singleton Class
 */
public class PropertyLoader {
    private static volatile PropertyLoader instance;

    public static PropertyLoader getInstance() {
        if (instance == null) {
            synchronized (PropertyLoader.class) {
                if (instance == null) {
                    instance = new PropertyLoader();
                }
            }
        }
        return instance;
    }

    /**
     * Property to save our platform
     */
    private String platform;

    /**
     * Property to save our app path
     */
    private String appPath;

    /**
     * platform Property getter
     * @return the platform value
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * platform Property setter
     * @param platform new value for platform
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getAppPath() {
        return appPath;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }
}
