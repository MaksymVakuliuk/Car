package service;

import model.CarWheel;

public interface CarWheelService {
    public CarWheel getCarWheel();

    public double changeToNew();

    public double eraseWheel(double delta);

    public String printToConsole();
}
