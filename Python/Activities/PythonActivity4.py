
print("Welcome to the Rock-Scissors-Paper Game!")
user1 = input("First User : ")
user2 = input("Second User : ")
#Input the user selection
while True:
    user1_Input = input(user1 + " , Which one you select - Rock, Scissors or Paper?").lower()
    print(user1 + " have selected " + user1_Input)
    user2_Input = input(user2 + " , Which one you select - Rock, Scissors or Paper?").lower()
    print(user2 + " have selected " + user2_Input)
    if user1_Input == user2_Input:
        print("It's a tie")
    elif user1_Input == 'rock':
        if user2_Input == 'scissors':
            print(user1 + " wins!!!")
        elif user2_Input == 'paper':
            print(user2 + " wins!!!")
        else:
            print(user2 + "! Your input is incorrect")
    elif user1_Input == 'scissors':
        if user2_Input == 'paper':
            print(user1 + " wins!!!")
        elif user2_Input == 'rock':
            print(user2 + " wins!!!")
        else:
            print(user2 + "! Your input is incorrect")
    elif user1_Input == 'paper':
        if user2_Input == 'rock':
            print(user1 + " wins!!!")
        elif user2_Input == 'scissors':
            print(user2 + " wins!!!")
        else:
            print(user2 + "! Your input is incorrect")
    else:
        print(user1 + "!, Your input is incorrect")
    repeat = input("Do you want to play another round - Y/N?").lower()
    if repeat == 'y':
        continue
    elif repeat == 'n':
        raise SystemExit
    else:
        print("You have entered invalid option! Bye bye")
        raise SystemExit

    
    
