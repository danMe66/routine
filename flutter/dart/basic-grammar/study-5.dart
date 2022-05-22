/**
 * Control flow statements:控制流语句
 * if and else
 * for loops
 * while and do-while loops
 * break and continue
 * switch and case
 * assert
 */
void main() {
  if (isRaining()) {
    you.bringRainCoat();
  } else if (isSnowing()) {
    you.wearJacket();
  } else {
    car.putTopDown();
  }

  var message = StringBuffer('Dart is fun');
  for (var i = 0; i < 5; i++) {
    message.write('!');
  }

  var callbacks = [];
  for (var i = 0; i < 2; i++) {
    callbacks.add(() => print(i));
  }
  callbacks.forEach((c) => c());

  for (final candidate in candidates) {
    candidate.interview();
  }

  while (!isDone()) {
    doSomething();
  }

  do {
    printLine();
  } while (!atEndOfPage());

  for (int i = 0; i < candidates.length; i++) {
    var candidate = candidates[i];
    if (candidate.yearsExperience < 5) {
      continue;
    }
    candidate.interview();
  }

  candidates.where((c) => c.yearsExperience >= 5).forEach((c) => c.interview());

  var command = 'OPEN';
  switch (command) {
    case 'CLOSED':
      executeClosed();
      break;
    case 'PENDING':
      executePending();
      break;
    case 'APPROVED':
      executeApproved();
      break;
    case 'DENIED':
      executeDenied();
      break;
    case 'OPEN':
      executeOpen();
      break;
    default:
      executeUnknown();
  }

  var command = 'OPEN';
  switch (command) {
    case 'OPEN':
      executeOpen();
    // ERROR: Missing break

    case 'CLOSED':
      executeClosed();
      break;
  }

  var command = 'CLOSED';
  switch (command) {
    case 'CLOSED':
      executeClosed();
      continue nowClosed;
    // Continues executing at the nowClosed label.

    nowClosed:
    case 'NOW_CLOSED':
      // Runs for both CLOSED and NOW_CLOSED.
      executeNowClosed();
      break;
  }

  // Make sure the variable has a non-null value.
  assert(text != null);

// Make sure the value is less than 100.
  assert(number < 100);

// Make sure this is an https URL.
  assert(urlString.startsWith('https'));

  assert(urlString.startsWith('https'),
      'URL ($urlString) should start with "https".');
}
