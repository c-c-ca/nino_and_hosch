package locks;

/**
 * A test module for CombinationLock.
 */
class CombinationLockTest {

 private CombinationLock lock;  // the Lock to test

 /**
  * Create a combinationLockTest.
  */
 public CombinationLockTest () {
   lock = null;
 }

 /**
  * Run this test.
  */
 public void runTest () {
   testLock(0);    // smallest combination
   testLock(123);  // "random" combination
   testLock(999);  // largest combination
 }

 /**
  * Test a lock with the specified combination.
  */
 private void testLock (int combination) {
   lock = new CombinationLock(combination);
   testInitialState();
   testClose();
   testOpen(combination);
 }
 
 /**
  * Test the initial state of lock.
  */
 private void testInitialState() {
   verify(lock.isOpen(), "initial state");
 }
 
 /**
  * Test that the lock closes. Should be invoked with an unlocked (open) lock.
  */
 private void testClose() {
   lock.close();
   verify(!lock.isOpen(), "close opened lock");
   lock.close();
   verify(!lock.isOpen(), "close closed lock");
 }

 /**
  * Test that the lock opens.
  */
 private void testOpen (int combination) {
   int badCombination = (combination + 1) % 1000;
   // test with correct combination:
   lock.close();
   lock.open(combination); // open closed lock
   verify(lock.isOpen(), "open closed lock");
   lock.open(combination); // open opened lock
   verify(lock.isOpen(), "open opened lock");
   // test with incorrect combination:
   lock.open(badCombination); // try opened lock
   verify(lock.isOpen(), "bad comb, opened lock");
   lock.close();
   lock.open(badCombination); // try closed lock
   verify(!lock.isOpen(), "bad comb, closed lock");
 }
 
 /**
  * Verify the specified test. Write the message if failure.
  */
 private void verify (boolean test, String message) {
   if (!test)
     System.out.println("Verification failed: " + message);
 }
}
