import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class DragDropTest {
    @Test
    void actionDragDrop() {
        step("Перейти на сатй https://the-internet.herokuapp.com/drag_and_drop", () -> {
            open("https://the-internet.herokuapp.com/drag_and_drop");
        });
        step("Перенесите прямоугольник А на место В", () -> {
            $("#column-a").dragAndDropTo("#column-b");
        });
        step("Проверить, что прямоугольник А переместился на место В", () -> {
            $("#column-a").shouldHave(text("B"));
            $("#column-b").shouldHave(text("A"));
        });

    }
}
