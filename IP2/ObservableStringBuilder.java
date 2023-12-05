import java.util.ArrayList;
import java.util.List;

public class ObservableStringBuilder {
    private StringBuilder stringBuilder;
    private List<StringBuilderListener> listeners;

    public ObservableStringBuilder() {
        stringBuilder = new StringBuilder();
        listeners = new ArrayList<>();
    }

    public void addListener(StringBuilderListener listener) {
        listeners.add(listener);
    }

    public void removeListener(StringBuilderListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        for (StringBuilderListener listener : listeners) {
            listener.onStringBuilderChanged(this);
        }
    }

    // Делегированные методы StringBuilder с уведомлением подписчиков
    public ObservableStringBuilder append(String str) {
        stringBuilder.append(str);
        notifyListeners();
        return this;
    }

    public ObservableStringBuilder delete(int start, int end) {
        stringBuilder.delete(start, end);
        notifyListeners();
        return this;
    }

    public String toString() {
        return stringBuilder.toString();
    }

    public interface StringBuilderListener {
        void onStringBuilderChanged(ObservableStringBuilder stringBuilder);
    }
}
