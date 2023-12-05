import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObservableStringBuilderTest {

    @Test
    public void testStringBuilderListener() {
        ObservableStringBuilder stringBuilder = new ObservableStringBuilder();
        TestListener listener = new TestListener();
        stringBuilder.addListener(listener);

        stringBuilder.append("Hello");
        assertEquals("Hello", stringBuilder.toString());
        assertTrue(listener.isChanged());

        stringBuilder.delete(0, 2);
        assertEquals("llo", stringBuilder.toString());
        assertTrue(listener.isChanged());

        stringBuilder.removeListener(listener);
        listener.reset();
        stringBuilder.append(" World");
        assertEquals("llo World", stringBuilder.toString());
        assertFalse(listener.isChanged());
    }

    private static class TestListener implements ObservableStringBuilder.StringBuilderListener {
        private boolean changed = false;

        @Override
        public void onStringBuilderChanged(ObservableStringBuilder stringBuilder) {
            changed = true;
        }

        public boolean isChanged() {
            return changed;
        }

        public void reset() {
            changed = false;
        }
    }
}
