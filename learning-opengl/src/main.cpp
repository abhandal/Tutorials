// Code is rewritten using code from learnopengl.com

// OpenGL helpers
#include "glew\glew.h"
#include "glfw\glfw3.h"

// Core libraries
#include <cmath>
#include <cstdio>
#include <iostream>
#include <string>
#include <fstream>
#include "shader.h"

//Image Load
#include "stb/stb_image.h"

//GLM libraries
#include <glm/glm.hpp>
#include <glm/gtc/matrix_transform.hpp>
#include <glm/gtc/type_ptr.hpp>

void framebuffer_size_callback(GLFWwindow* window, int width, int height);
void processInput(GLFWwindow *window);

const unsigned int SCR_WIDTH = 800;
const unsigned int SCR_HEIGHT = 600;

int main() {

	// Rectangle that contains color data and texture coordinates
	float vertices[] = {
		-0.5f, -0.5f, -0.5f,  0.0f, 0.0f,
		0.5f, -0.5f, -0.5f,  1.0f, 0.0f,
		0.5f,  0.5f, -0.5f,  1.0f, 1.0f,
		0.5f,  0.5f, -0.5f,  1.0f, 1.0f,
		-0.5f,  0.5f, -0.5f,  0.0f, 1.0f,
		-0.5f, -0.5f, -0.5f,  0.0f, 0.0f,

		-0.5f, -0.5f,  0.5f,  0.0f, 0.0f,
		0.5f, -0.5f,  0.5f,  1.0f, 0.0f,
		0.5f,  0.5f,  0.5f,  1.0f, 1.0f,
		0.5f,  0.5f,  0.5f,  1.0f, 1.0f,
		-0.5f,  0.5f,  0.5f,  0.0f, 1.0f,
		-0.5f, -0.5f,  0.5f,  0.0f, 0.0f,

		-0.5f,  0.5f,  0.5f,  1.0f, 0.0f,
		-0.5f,  0.5f, -0.5f,  1.0f, 1.0f,
		-0.5f, -0.5f, -0.5f,  0.0f, 1.0f,
		-0.5f, -0.5f, -0.5f,  0.0f, 1.0f,
		-0.5f, -0.5f,  0.5f,  0.0f, 0.0f,
		-0.5f,  0.5f,  0.5f,  1.0f, 0.0f,

		0.5f,  0.5f,  0.5f,  1.0f, 0.0f,
		0.5f,  0.5f, -0.5f,  1.0f, 1.0f,
		0.5f, -0.5f, -0.5f,  0.0f, 1.0f,
		0.5f, -0.5f, -0.5f,  0.0f, 1.0f,
		0.5f, -0.5f,  0.5f,  0.0f, 0.0f,
		0.5f,  0.5f,  0.5f,  1.0f, 0.0f,

		-0.5f, -0.5f, -0.5f,  0.0f, 1.0f,
		0.5f, -0.5f, -0.5f,  1.0f, 1.0f,
		0.5f, -0.5f,  0.5f,  1.0f, 0.0f,
		0.5f, -0.5f,  0.5f,  1.0f, 0.0f,
		-0.5f, -0.5f,  0.5f,  0.0f, 0.0f,
		-0.5f, -0.5f, -0.5f,  0.0f, 1.0f,

		-0.5f,  0.5f, -0.5f,  0.0f, 1.0f,
		0.5f,  0.5f, -0.5f,  1.0f, 1.0f,
		0.5f,  0.5f,  0.5f,  1.0f, 0.0f,
		0.5f,  0.5f,  0.5f,  1.0f, 0.0f,
		-0.5f,  0.5f,  0.5f,  0.0f, 0.0f,
		-0.5f,  0.5f, -0.5f,  0.0f, 1.0f
	};
	unsigned int indices[] = {
		0, 1, 3, // first triangle
		1, 2, 3  // second triangle
	};

	// cube position in world space
	glm::vec3 cubePositions[] = {
		glm::vec3(0.0f,  0.0f,  0.0f),
		glm::vec3(2.0f,  5.0f, -15.0f),
		glm::vec3(-1.5f, -2.2f, -2.5f),
		glm::vec3(-3.8f, -2.0f, -12.3f),
		glm::vec3(2.4f, -0.4f, -3.5f),
		glm::vec3(-1.7f,  3.0f, -7.5f),
		glm::vec3(1.3f, -2.0f, -2.5f),
		glm::vec3(1.5f,  2.0f, -2.5f),
		glm::vec3(1.5f,  0.2f, -1.5f),
		glm::vec3(-1.3f,  1.0f, -1.5f)
	};

	glfwInit();
	// Ensures that the system has atleast openGL version 3.3
	glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
	glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
	//Ensures that the core profile is used (as opposed to intermediate)
	glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

	// Create window object
	GLFWwindow* window = glfwCreateWindow(SCR_WIDTH, SCR_HEIGHT, "LearnOpenGL", nullptr, nullptr);

	// terminate if window is not created
	if (window == NULL) {
		std::cout << "Failed to create GLFW window" << std::endl;
		glfwTerminate();
		return -1;
	}

	// Creates context
	glfwMakeContextCurrent(window);

	// Tell OpenGL the size of the rendering window (ViewPort)
	//Note: This could be different from the window object dimensions
	// register the readjust method call
	glfwSetFramebufferSizeCallback(window, framebuffer_size_callback);

	// Set to true so GLEW can use modern approach for pointers functions and extensions
	glewExperimental = GL_TRUE;

	// initialize GLAD since it manages function pointers for OpenGL
	if (glewInit() != GLEW_OK) {
		std::cout << "Failed to initialize GLAD" << std::endl;
		return -1;
	}

	// Enabled depth testing
	glEnable(GL_DEPTH_TEST);

	/*Compile and build shaders */
	Shader shader("res/vertex.shader", "res/fragment.shader"); 

	/*Set up vertex data and buffers*/
	// Creating a vector buffer object and vector array object
	// Vector Array Object is used to store the VBO and simplify the creation of VBOs
	// Element Buffer allow the ability for us store unique indices instead of having overlapping vertices
	unsigned int VBO, VAO, EBO;
	glGenVertexArrays(1, &VAO);
	glGenBuffers(1, &VBO);
	glGenBuffers(1, &EBO);

	// Bind the vertex array object
	glBindVertexArray(VAO);
	// Binding the VBO to the array_buffer
	glBindBuffer(GL_ARRAY_BUFFER, VBO);
	glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO);

	//copies the previously defined vertex into buffer memory
	/*
	 * arg1: type of buffer we want to copy data into
	 * arg2: the size of data
	 * arg3: the data
	 * arg4: how we want the graphic card to manage the data (static, dynamic, stream)
	 */
	glBufferData(GL_ARRAY_BUFFER, sizeof(vertices), vertices, GL_STATIC_DRAW); // VBO
	glBufferData(GL_ELEMENT_ARRAY_BUFFER, sizeof(indices), indices, GL_STATIC_DRAW); // EBO

	// Tell OpenGL how to interpret our vertex data
	/*
	 * arg1: starting byte location of the vector
	 * arg2: size of the vertex attribue (3d = 3)
	 * arg3: type of data in vertex (float)
	 * arg4: do we want data to be normalized, our is already normalized (-1.0 to 1.0)
	 * arg5: location of the next vertex
	 * arg6: offset, the position of data is at point 0 so we put 0
	 */
	 // position attribute
	glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 5 * sizeof(float), (void*)0);
	glEnableVertexAttribArray(0);
	// texture coord attribute
	glVertexAttribPointer(1, 2, GL_FLOAT, GL_FALSE, 5 * sizeof(float), (void*)(3 * sizeof(float)));
	glEnableVertexAttribArray(1);

	/* Texture 1*/

	// Generating a texture
	/*
	* arg1: number of texture to generate
	* arg2: stores the generated texture into this memory address
	*/
	unsigned int texture1, texture2;
	glGenTextures(1, &texture1);

	// Bind the texture
	glBindTexture(GL_TEXTURE_2D, texture1);

	/*
	 *texture wrapping attribute
	 * arg1: texture target
	 * arg2: the texture option and coordinate (x,y,z maps to s,r,t)
	 * arg3: texture mapping mode (repeat, mirror repeat, clamp to edge, and clamp to border)
	 */
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);

	// texture filtering attribute
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR); // uses nearest when texture is scaled downward
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR); // uses linear when texture is scaled upward

	// load image
	/*
	 * arg1: location of image
	 * arg2,3,4: stb will fill in the width, height, and color channel with info from image
	 */
	int width, height, nrChannels;
	// Flip image
	stbi_set_flip_vertically_on_load(true);
	unsigned char *data = stbi_load("res/container.jpg", &width, &height, &nrChannels, 0);

	if(data)
	{
		// Generate the texture using the loaded image data
		/*
		* arg1: texture target (we want to bind it to 2D)
		* arg2: mipmap level, 0 means its at base level and we can modify it manually
		* arg3: the format to store the texture in
		* arg4, 5: sets the width and height of resulting texture
		* arg6: always set this to 0
		* arg7,8: specify the format and datatype of source image (we loaded an RGB image and store them as bytes)
		* arg9: actual image data
		*/
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width, height, 0, GL_RGB, GL_UNSIGNED_BYTE, data);
		glGenerateMipmap(GL_TEXTURE_2D);
	}
	else
	{
		cout << "Failed to load texture" << endl;
	}

	// free image memory
	stbi_image_free(data);

	// texture 2
	// ---------
	glGenTextures(1, &texture2);
	glBindTexture(GL_TEXTURE_2D, texture2);
	// set the texture wrapping parameters
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);	// set texture wrapping to GL_REPEAT (default wrapping method)
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
	// set texture filtering parameters
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

	// load image, create texture and generate mipmaps
	data = stbi_load("res/awesomeface.png", &width, &height, &nrChannels, 0);
	if (data)
	{
		// note that the awesomeface.png has transparency and thus an alpha channel, so make sure to tell OpenGL the data type is of GL_RGBA
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, data);
		glGenerateMipmap(GL_TEXTURE_2D);
	}
	else
	{
		std::cout << "Failed to load texture" << std::endl;
	}
	stbi_image_free(data);

	// tell opengl for each sampler to which texture unit it belongs to (only has to be done once)
	// -------------------------------------------------------------------------------------------
	shader.use();
	shader.setInt("texture1", 0);
	shader.setInt("texture2", 1);

	// pass projection matrix to shader (as projection matrix rarely changes there's no need to do this per frame)
	// -----------------------------------------------------------------------------------------------------------
	glm::mat4 projection = glm::perspective(glm::radians(45.0f), (float)SCR_WIDTH / (float)SCR_HEIGHT, 0.1f, 100.0f);
	shader.setMat4("projection", projection);

	// Create a while loop since we want the application to keep drawing images and handling inputs
	// glfwWindowShouldClose: checks if window has been instructed to close
	// glfwPollEvents: checks if events are triggered (kb/mouse inputs)
	// glfwSwapBuffers: swaps color buffer - removes artifacts and image appears properly
	while (!glfwWindowShouldClose(window)) {
		// Added here so for every iteration the program checks key inputs
		processInput(window);

		//rendering commands
		glClearColor(0.2f, 0.3f, 0.3f, 1.0f); //sets the color when screen is cleared
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the color buffer using the set color

		// activates texture unit
		glActiveTexture(GL_TEXTURE0);
		// Bind The texture
		glBindTexture(GL_TEXTURE_2D, texture1);

		//same for texture 2
		glActiveTexture(GL_TEXTURE1);
		glBindTexture(GL_TEXTURE_2D, texture2);

		//Use the shader
		shader.use();

		// Transformations
		glm::mat4 view;
		float radius = 10.0f;
		float camX = sin(glfwGetTime()) * radius;
		float camZ = cos(glfwGetTime()) * radius;
		view = glm::lookAt(glm::vec3(camX, 0.0f, camZ), glm::vec3(0.0f, 0.0f, 0.0f), glm::vec3(0.0f, 1.0f, 0.0f));
		shader.setMat4("view", view);

		// Bind the vertex array object 
		glBindVertexArray(VAO);
		
		// Loops 10 times to render 10 rotated cubes
		for (unsigned int i = 0; i < 10; i++)
		{
			glm::mat4 model;
			model = glm::translate(model, cubePositions[i]);
			float angle = 20.0f * i;
			model = glm::rotate(model, glm::radians(angle), glm::vec3(1.0f, 0.3f, 0.5f));
			model = glm::rotate(model, (float)glfwGetTime() * glm::radians(50.0f), glm::vec3(0.5f, 1.0f, 0.0f));
			shader.setMat4("model", model);

			glDrawArrays(GL_TRIANGLES, 0, 36);
		}

		// checks and call events and swaps buffers
		glfwSwapBuffers(window);
		glfwPollEvents();
	}

	// Destroys all resources allocated to the application
	glfwTerminate();

	return 0;
}

// Readjusts the viewport when user resizes the window
void framebuffer_size_callback(GLFWwindow* window, int width, int height) {
	glViewport(0, 0, width, height);
}

// Captures and processes keyboard inputs
void processInput(GLFWwindow *window) {
	// If user presses ESC key then close the window
	if (glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_PRESS) {
		glfwSetWindowShouldClose(window, true);
	}
}