package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByIdActionTest {

    @Test
    void execute() throws SQLException {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item searchItem = new Item("Search item");
        tracker.add(searchItem);
        FindByIdAction findActionById = new FindByIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(4);
        when(input.askInt(any(String.class))).thenReturn(1);

        findActionById.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find item by id ===" + ln + searchItem + ln);
    }
}