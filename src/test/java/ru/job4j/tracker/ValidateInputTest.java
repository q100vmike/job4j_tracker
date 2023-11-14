package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new MockInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenRightInput() {
        Output out = new StubOutput();
        Input in = new MockInput(
                new String[] {"3"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(3);
    }

    @Test
    void whenMultyInput() {
        Output out = new StubOutput();
        Input in = new MockInput(
                new String[] {"9", "999", "2", "3"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("");
        selected = input.askInt("");
        selected = input.askInt("Enter menu:");
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(3);
    }

    @Test
    void whenMinusInput() {
        Output out = new StubOutput();
        Input in = new MockInput(
                new String[] {"-9"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("");
        assertThat(selected).isEqualTo(-9);
    }
}