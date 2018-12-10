package uy.edu.cei.Obligatorio.Client.Controller;

import uy.edu.cei.Obligatorio.Client.ui.Panel.GeneralaPanel;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;

public interface MasterController {
	public GeneralaPanel darPanel();
	public void respuesta(GameNotification gn);
}
