package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeleteActionTest {

    @Test
    public void execute() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("TestItem"));
        DeleteAction del = new DeleteAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(3);
        when(input.askInt(any(String.class))).thenReturn(1);

        del.execute(input, tracker);
        assertThat(tracker.findAll()).isEmpty();
    }
}