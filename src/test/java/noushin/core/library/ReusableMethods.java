package noushin.core.library;

/**
 * For common reusable methods that don't need a driver, and They aren't related to ui
 */
public class ReusableMethods {
    private static final PropertyLoader properties = PropertyLoader.getInstance();

    public Double getFormattedAmount(String amount) {
        return Double.parseDouble(amount.substring(1));
    }

    public boolean isAndroid() {
        return properties.getPlatform().equalsIgnoreCase(Constants.Platforms.ANDROID);
    }

    public boolean isIos() {
        return properties.getPlatform().equalsIgnoreCase(Constants.Platforms.IOS);
    }
}
