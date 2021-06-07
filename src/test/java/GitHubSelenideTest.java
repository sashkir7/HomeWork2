import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSelenideTest {

    @BeforeAll
    public static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void pageSoftAssertionsShouldHaveJUnit5() {
        open("https://github.com");
        $("[name='q']").setValue("Selenide").pressEnter();
        $("ul.repo-list li").find("a").click();
        $("[data-content='Wiki']").click();
        $(byText("Soft assertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5"));
    }
}
