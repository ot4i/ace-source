package com.ibm.dev;

import java.io.InputStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ibm.integration.test.v1.NodeSpy;
import com.ibm.integration.test.v1.SpyObjectReference;
import com.ibm.integration.test.v1.TestMessageAssembly;
import com.ibm.integration.test.v1.TestSetup;
import com.ibm.integration.test.v1.exception.TestException;

import static com.ibm.integration.test.v1.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;



public class ACME_CoffeeRoasters_UnitTest {

	/*
	 * ACME_CoffeeRoasters_Application_ACME_CoffeeRoasters_Flow_Transform_0001_Test
	 */

	@BeforeAll
	public static void setup() throws Exception {
	}

	@AfterAll
	public static void cleanup() throws Exception {
	}

	@AfterEach
	public void cleanupTest() throws TestException {
		// Ensure any mocks created by a test are cleared after the test runs 
		TestSetup.restoreAllMocks();
	}

	@Test
	public void ACME_CoffeeRoasters_UnitTest_TestCase_001() throws TestException {
		
			// Define the SpyObjectReference
			SpyObjectReference nodeReference = new SpyObjectReference().application("ACME_CoffeeRoasters_Application")
					.messageFlow("ACME_CoffeeRoasters_Flow").node("Transform");

			// Initialise a NodeSpy
			NodeSpy nodeSpy = new NodeSpy(nodeReference);

			// Declare a new TestMessageAssembly object for the message being sent into the node
			TestMessageAssembly inputMessageAssembly = new TestMessageAssembly();

			// Create a Message Assembly from the input data file
			try {
				String messageAssemblyPath = "/ACME_CoffeeRoasters_Flow_Transform_0001_cca7f6d3-81d5-4c2a-beb9-c853848b0149_input_data.mxml";
				InputStream messageStream = Thread.currentThread().getContextClassLoader()
						.getResourceAsStream(messageAssemblyPath);
				if (messageStream == null) {
					throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
				}
				inputMessageAssembly.buildFromRecordedMessageAssembly(messageStream);
			} catch (Exception ex) {
				throw new TestException("Failed to load input message", ex);
			}

			// Call the message flow node with the Message Assembly
			nodeSpy.evaluate(inputMessageAssembly, true, "in");

			// Assert the number of times that the node is called
			assertThat(nodeSpy, nodeCallCountIs(1));

			// Assert the terminal propagate count for the message
			assertThat(nodeSpy, terminalPropagateCountIs("out", 1));

			// Compare Output Message 1 at output terminal out

			try {
				TestMessageAssembly actualMessageAssembly = null;
				TestMessageAssembly expectedMessageAssembly = null;

				// Get the TestMessageAssembly object for the actual propagated message
				actualMessageAssembly = nodeSpy.propagatedMessageAssembly("out", 1);

				// Assert output message body data
				// Get the TestMessageAssembly object for the expected propagated message
				expectedMessageAssembly = new TestMessageAssembly();

				// Create a Message Assembly from the expected output mxml resource
				String messageAssemblyPath = "/ACME_CoffeeRoasters_Flow_Transform_0001_ba23be7c-885e-4c82-8b43-5f07e884b0ab_output_data.mxml";
				InputStream messageStream = Thread.currentThread().getContextClassLoader()
						.getResourceAsStream(messageAssemblyPath);
				if (messageStream == null) {
					throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
				}
				expectedMessageAssembly.buildFromRecordedMessageAssembly(messageStream);

				// Assert that the actual message tree matches the expected message tree
				//assertThat(actualMessageAssembly, equalsMessage(expectedMessageAssembly).ignoreDateTime().ignoreTimeStamps());

			} catch (Exception ex) {
				throw new TestException("Failed to compare with expected message", ex);
			}

		}
}