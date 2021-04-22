package testData;

import enums.ProjectType;
import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider(name = "Create Project")
    public static Object[][] createData() {
        return new Object[][] {
                {"Project 1", ProjectType.SINGLE_FOR_ALL_CASES},
                {"Project 2", ProjectType.MULTIPLE},
                {"Project 3", ProjectType.SINGLE_WITH_BASELINE},
                {"Project 4", ProjectType.SINGLE_WITH_BASELINE},
        };
    }
}
