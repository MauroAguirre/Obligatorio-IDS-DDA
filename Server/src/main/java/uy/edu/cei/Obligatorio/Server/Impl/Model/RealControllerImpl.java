package uy.edu.cei.Obligatorio.Server.Impl.Model;

import java.util.List;

import uy.edu.cei.Obligatorio.Common.Observer;
import uy.edu.cei.Obligatorio.Common.Controller.RealController;

public class RealControllerImpl implements RealController {
	
	private List<Observer> observers;
	
	public RealControllerImpl(List<Observer> observers) {
		this.observers = observers;
	}

}
