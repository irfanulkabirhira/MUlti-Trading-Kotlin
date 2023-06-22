
// WorkerThread class
class WorkerThread(private val name: String) : Thread() {
    override fun run() {
        println("Thread $name is running")
        try {
            // Simulate some work
            sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        println("Thread $name has completed")
    }
}

// Main program
fun main() {
    println("Main thread started")

    // Create and start multiple worker threads
    val thread1 = WorkerThread("Thread 1")
    val thread2 = WorkerThread("Thread 2")
    val thread3 = WorkerThread("Thread 3")

    thread1.start()
    thread2.start()
    thread3.start()

    // Wait for all threads to complete
    try {
        thread1.join()
        thread2.join()
        thread3.join()
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }

    println("Main thread finished")
}
