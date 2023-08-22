package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;
public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
    @Test
    public void whenComparatorByNameAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobByName().thenComparing(new JobByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
    @Test
    public void whenComparatorByNameAsc() {
        Comparator<Job> cmpNamePriority = new JobByName();
        int rsl = cmpNamePriority.compare(
                new Job("a", 0),
                new Job("b", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
    @Test
    public void whenComparatorByNameDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName();
        int rsl = cmpNamePriority.compare(
                new Job("a", 0),
                new Job("b", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
    @Test
    public void whenComparatorByPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
    @Test
    public void whenComparatorByPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameEqualsAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("a", 20),
                new Job("a", 10)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameEqualsAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobByName().thenComparing(new JobByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("a", 10),
                new Job("a", 20)
        );
        assertThat(rsl).isLessThan(0);
    }
}