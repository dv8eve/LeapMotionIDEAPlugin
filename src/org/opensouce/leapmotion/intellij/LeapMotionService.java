package org.opensouce.leapmotion.intellij;

import com.intellij.history.LocalHistory;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.compiler.CompileContext;
import com.intellij.openapi.compiler.CompileStatusNotification;
import com.intellij.openapi.compiler.CompilerBundle;
import com.intellij.openapi.compiler.CompilerManager;
import com.intellij.openapi.project.Project;

/**
 * @author edewit@redhat.com
 */
public class LeapMotionService {

  public void waitForSign(final Project project) {
    CompilerManager.getInstance(project).rebuild(new CompileStatusNotification() {
      public void finished(boolean aborted, int errors, int warnings, final CompileContext compileContext) {
        if (aborted) return;

        String text = new Presentation().getText();
        LocalHistory.getInstance().putSystemLabel(project, errors == 0
            ? CompilerBundle.message("rebuild.lvcs.label.no.errors", text)
            : CompilerBundle.message("rebuild.lvcs.label.with.errors", text));
      }
    });

  }
}
