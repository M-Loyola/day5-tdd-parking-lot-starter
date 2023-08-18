# Story 1
Case 1: Given a parking lot and a car, When park the car, Then return a parking ticket 
Case 2: Given a parking lot with a parked car and a parking ticket, When fetch the car, Then return the parked car 
Case 3: Given a parking lot with two parked cars, and two parking tickets, When fetch the car twice, Then return with each ticket 
Case 4: Given a parking lot, and a wrong parking ticket, When fetch the car, Then return nothing
Case 5: Given a parking lot and a used parking ticket, When fetch the car, Then return nothing 
Case 6: Given a parking lot without any position and a car, When park the car, Then return nothing 

# Story2
Case 1 - Given a parking lot, and an unrecognized ticket, When fetch the car, Then return nothing with error message "Unrecognized parking ticket.”
Case 2 - Given a parking lot, and a used ticket, When fetch the car, Then return nothing with error message "Unrecognized parking ticket."
Case 3 - Given a parking lot without any position, and a car, When park the car, Then return nothing with error message "No available position."