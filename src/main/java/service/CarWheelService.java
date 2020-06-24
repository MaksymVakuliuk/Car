package service;

import model.CarWheel;

public interface CarWheelService {
    double changeToNew(CarWheel carWheel);

    double eraseWheel(CarWheel carWheel, double delta);

    String printToConsole(CarWheel carWheel);
}
