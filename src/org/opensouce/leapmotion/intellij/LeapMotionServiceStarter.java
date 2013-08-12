package org.opensouce.leapmotion.intellij;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.ProjectManager;
import org.jetbrains.annotations.NotNull;

/**
 * @author edewit@redhat.com
 */
public class LeapMotionServiceStarter implements ProjectComponent {

  public void initComponent() {
    // TODO: insert component initialization logic here
    System.out.println("LeapMotionServiceStarter.initComponent");
  }

  public void disposeComponent() {
    // TODO: insert component disposal logic here
  }

  @NotNull
  public String getComponentName() {
    return "LeapMotionServiceStarter";
  }

  @Override
  public void projectOpened() {
    LeapMotionService service = ServiceManager.getService(LeapMotionService.class);
    service.waitForSign(ProjectManager.getInstance().getDefaultProject());
  }

  @Override
  public void projectClosed() {
  }
}
