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
        $("ul.repo-list li a").click();
        $("[data-content='Wiki']").click();

        var ulSection = $("ul[data-filterable-for='wiki-pages-filter']");
        ulSection.find("button").click();
        ulSection.find(byText("SoftAssertions")).click();

        $("#wiki-body").shouldHave(text("Using JUnit5"));
    }
}
