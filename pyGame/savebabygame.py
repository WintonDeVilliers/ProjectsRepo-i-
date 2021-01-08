import pygame
import random


pygame.init() #Start Pygame

screen_width = 1020
screen_height = 680

screen = pygame.display.set_mode((screen_width,screen_height)) #Start the screen
background_image = pygame.image.load("jozi2.jpg").convert()


player = pygame.image.load("realplayer.png")
enemy = pygame.image.load("ghogho.png")
enemy2 = pygame.image.load("worm.png")
enemy3 = pygame.image.load("blobmonster.png")
enemy4 = pygame.image.load("evileye.png")
prize_object = pygame.image.load("baby.png")

# player height and width
image_height = player.get_height()
image_width = player.get_width()
# enemy height and width
enemy_height = enemy.get_height()
enemy_width = enemy.get_width()
enemy2_height = enemy2.get_height()
enemy2_width =  enemy2.get_width()
enemy3_height = enemy3.get_height()
enemy3_width = enemy3.get_width()
enemy4_height = enemy4.get_height()
enemy4_width = enemy4.get_width()
# prize object height and width
prize_object_height = prize_object.get_height()
prize_object_width = prize_object.get_width()


print("This is the height of the player image: " +str(image_height))
print("This is the width of the player image: " +str(image_width))

# position of the player and enemy
# player position
playerXPosition = 100
playerYPosition = random.randint(0, screen_height - enemy_height)

prize_objectXPosition = 900
prize_objectYPosition = 250


# enemy position
enemyXPosition = screen_width
enemyYPosition = random.randint(0, screen_height - enemy_height)

enemy2XPosition = screen_width
enemy2YPosition = random.randint(500, 700)

enemy3XPosition = screen_width
enemy3YPosition = random.randint(0, screen_height - enemy3_height)

enemy4XPosition = screen_width
enemy4YPosition = random.randint(0, screen_height - enemy3_height)

# Check if up or down key is pressed
# while set to False they are "Not" pressed
keyUp = False
keyDown = False
keyRight = False
keyLeft = False
# Below is the game loop.
# The idea here is that the game logic runs over and over again.
# You need to refresh/update the screen window and apply changes to represent real time play.
while 1:

    screen.fill(0)  # clears the screen
    screen.blit(background_image, [0, 0])
    screen.blit(player, (playerXPosition, playerYPosition))  # THis draws the player image to the screen at the position specified
    screen.blit(enemy, (enemyXPosition, enemyYPosition))
    screen.blit(enemy2, (enemy2XPosition, enemy2YPosition))
    screen.blit(enemy3, (enemy3XPosition, enemy3YPosition))
    screen.blit(enemy4, (enemy4XPosition, enemy4YPosition))
    screen.blit(prize_object, (prize_objectXPosition, prize_objectYPosition))


    pygame.display.flip()   # This updates the screen.

    # This loops through events in the game.

    for event in pygame.event.get():

        #This event checks if the user quits the program, then if so it exits the program
        if event.type == pygame.QUIT:
            pygame.quit()
            exit(0)

        #This event checks if the user press a key down.
        if event.type == pygame.KEYDOWN:

            # Test if the key pressed is the one we want.

            if event.key == pygame.K_UP:
                keyUp = True
            if event.key == pygame.K_DOWN:
                keyDown = True
            if event.key == pygame.K_RIGHT:
                keyRight = True
            if event.key == pygame.K_LEFT:
                keyLeft = True

        # This event checks if the key is up (i.e not pressed by the user).
        if event.type == pygame.KEYUP:

            if event.key == pygame.K_UP:
                keyUp = False
            if event.key == pygame.K_DOWN:
                keyDown = False
            if event.key == pygame.K_RIGHT:
                keyRight = False
            if event.key ==pygame.K_LEFT:
                keyLeft = False

        #if event.type == pygame.K_RIGHT:

            #if event.key == pygame.


    # After events are checked for in the loop above and values are set,
    # check key pressed values and move player accordingly.

    # The coordinate system of the game window(screen) is that the top left corner is(0 ,0).
    # This means that if you wnat the player to move down you will have to invrease the y position.


    if keyUp == True:
        if playerYPosition > 0 : # This makes sure that user does not have the player above the window
            playerYPosition -= 2
    if keyDown == True:
        if playerYPosition < screen_height - image_height:  # This makes sure that the user does not move the player below the game window
            playerYPosition += 2

    if keyRight == True:
        if playerXPosition > 0:
            playerXPosition += 2

    if keyLeft == True:
        if playerXPosition > 0:
            playerXPosition -= 2


    # check for collision of the enemy with player .
    # To do this we need bounding boxes around the images of the player and enemy.
    # We then need to test if these boxes intersect. If they do then there is a collision.

    # Bounding box for the player :
    # The following updates the playerBox position to the player's position,
    # in effect making the box stay around the player image.

    playerBox = pygame.Rect(player.get_rect())
    playerBox.top = playerYPosition
    playerBox.left = playerXPosition

    # Bounding Box for prize_object:

    prize_objectBox = pygame.Rect(prize_object.get_rect())
    prize_objectBox.top = prize_objectYPosition
    prize_objectBox.left = prize_objectXPosition

    # Bounding box for enemy:

    enemyBox = pygame.Rect(enemy.get_rect())
    enemyBox.top = enemyYPosition
    enemyBox.left = enemyXPosition

    enemy2Box = pygame.Rect(enemy2.get_rect())
    enemy2Box.top = enemy2YPosition
    enemy2Box.left = enemy2XPosition

    enemy3Box = pygame.Rect(enemy3.get_rect())
    enemy3Box.top = enemy3YPosition
    enemy3Box.left = enemy3XPosition

    enemy4Box = pygame.Rect(enemy4.get_rect())
    enemy4Box.top = enemy4YPosition
    enemy4Box.left = enemy4XPosition

    # Test collision of the boxes :

    if playerBox.colliderect(enemyBox):
        print("You Lose!")

        pygame.quit()
        exit(0)

    if playerBox.colliderect(enemy2Box):
        print("You Lose!")

        pygame.quit()
        exit(0)

    if playerBox.colliderect(enemy3Box):
        print("You Lose!")

        pygame.quit()
        exit(0)

    if playerBox.colliderect(enemy4Box):
        print("You Lose!")

        pygame.quit()
        exit(0)

    # if player collides with prize object the player wins:

    if playerBox.colliderect(prize_objectBox):
        print("You win ! ")

        pygame.quit()
        exit(0)

    # Make enemy approach the player .

    enemyXPosition -= 2

    enemy2XPosition -= 2
    enemy2YPosition -=1

    enemy3XPosition -= 2
    enemy3YPosition += 1

    enemy4XPosition -= 3

# ================The game loop logic ends here. =============
