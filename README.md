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

# Story3
Can be ignored since it's included in the scope of story 4

# Story4
Case 1: Given a standard parking boy who manages two parking lots, both with available position and car, 
When park the car, Then the car will be parked to the first parking lot

Case 2: Given a standard parking boy who manages two parking lots, first is full and second has available position and a car, 
When park the car, Then the car will be parked in the second parking lot

Case 3: Given a standard parking boy who manages two parking lots, both with a parked car, and two parking tickets, 
When fetch the car twice, Then return the right car with each ticket

Case 4: Given a standard parking boy who manages two parking lots, and an unrecognized ticket ,
When fetch the car, Then return nothing with error message "Unrecognized parking ticket"

Case 5: Given a standard parking boy who manages two parking lots, and a used ticket, 
When fetch the car, Then return nothing with error "Unrecognized parking ticket"

Case 6: Given a standard parking boy, who manages two parking lots both without any position and a car, 
    When park the car, Then return nothing with error message "No Available Position"

# Story5
Case 1: Given a smart parking boy who manages two parking lots, both with available position and car,
When park the car, Then the car will be parked to the first parking lot

Case 2: Given a smart parking boy who manages two parking lots, first is full and second has available position and a car,
When park the car, Then the car will be parked in the second parking lot

Case 3: Given a smart parking boy who manages two parking lots, second parking lot has more available positions and a car,
When park the car, Then the car will be parked in the second parking lot

Case 4: Given a smart parking boy who manages two parking lots, first parking lot has more available positions and a car,
When park the car, Then the car will be parked in the first parking lot

Case 5: Given a smart parking boy who manages two parking lots, both with equal available positions and car,
When park the car, Then the car will be parked to the first parking lot

Case 6: Given a smart parking boy who manages two parking lots, both with a parked car, and two parking tickets,
When fetch the car twice, Then return the right car with each ticket

Case 7: Given a smart parking boy who manages two parking lots, and an unrecognized ticket ,
When fetch the car, Then return nothing with error message "Unrecognized parking ticket"

Case 8: Given a smart parking boy who manages two parking lots, and a used ticket,
When fetch the car, Then return nothing with error "Unrecognized parking ticket"

Case 9: Given a smart parking boy, who manages two parking lots both without any position and a car,
When park the car, Then return nothing with error message "No Available Position"

# Story6
Case 1: Given a super parking boy who manages two parking lots, both with available position and car,
When park the car, Then the car will be parked to the first parking lot

Case 2: Given a super parking boy who manages two parking lots, first is full and second has available position and a car,
When park the car, Then the car will be parked in the second parking lot

Case 3: Given a super parking boy who manages two parking lots, second parking lot has larger position rate and a car,
When park the car, Then the car will be parked in the second parking lot

Case 4: Given a super parking boy who manages two parking lots, first parking lot has larger position rate  and a car,
When park the car, Then the car will be parked in the first parking lot

Case 5: Given a super parking boy who manages two parking lots, both with a parked car, and two parking tickets,
When fetch the car twice, Then return the right car with each ticket

Case 6: Given a super parking boy who manages two parking lots, and an unrecognized ticket ,
When fetch the car, Then return nothing with error message "Unrecognized parking ticket"

Case 7: Given a super parking boy who manages two parking lots, and a used ticket,
When fetch the car, Then return nothing with error "Unrecognized parking ticket"

Case 8: Given a super parking boy, who manages two parking lots both without any position and a car,
When park the car, Then return nothing with error message "No Available Position"