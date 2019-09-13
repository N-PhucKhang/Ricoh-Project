package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object User
     
    /**
     * <p></p>
     */
    public static Object UserAdmin
     
    /**
     * <p></p>
     */
    public static Object No2
     
    /**
     * <p></p>
     */
    public static Object NoError
     
    /**
     * <p></p>
     */
    public static Object NotCSV
     
    /**
     * <p></p>
     */
    public static Object No18_
     
    /**
     * <p></p>
     */
    public static Object No19_
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            User = selectedVariables['User']
            UserAdmin = selectedVariables['UserAdmin']
            No2 = selectedVariables['No2']
            NoError = selectedVariables['NoError']
            NotCSV = selectedVariables['NotCSV']
            No18_ = selectedVariables['No18_']
            No19_ = selectedVariables['No19_']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
