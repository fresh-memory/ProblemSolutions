/*
* Synchronized keyword
* Notice how notifyAll() is called
* Throws InterruptedException
*/

public class BlockingQueue {

  private List queue = new LinkedList();
  private int  limit = 10;

  public BlockingQueue(int limit){
    this.limit = limit;
  }


  public synchronized void enqueue(Object item)
  throws InterruptedException  {
    while(this.queue.size() == this.limit) {
      wait();
    }

    // if queue.size()==0, likely some one is waiting for dequeue
    // notify all about the addition so they can dequeue
    if(this.queue.size() == 0) {
      notifyAll();
    }
    this.queue.add(item);
  }


  public synchronized Object dequeue()
  throws InterruptedException{
    while(this.queue.size() == 0){
      wait();
    }
    // Likely someone is waiting for enqueue
    // notify other threads about the removal so they can enqueue
    if(this.queue.size() == this.limit){
      notifyAll();
    }

    return this.queue.remove(0);
  }

}
  
