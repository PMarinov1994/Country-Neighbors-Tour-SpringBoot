package com.vmware.task.vmware.services;

import com.vmware.task.vmware.model.countryTour.TourInfo;
import com.vmware.task.vmware.model.countryTour.TourInput;

public interface ITourCalculator
{
    public TourInfo calculate(TourInput input);
}
