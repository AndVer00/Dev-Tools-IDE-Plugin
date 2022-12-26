import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import org.jetbrains.annotations.NotNull;

public class LogWindowFactory implements ToolWindowFactory {

    @Override public void createToolWindowContent(@NotNull Project project, ToolWindow toolWindow){
        toolWindow.getComponent().add(new MyLogWindow().getContent());
    }
}