/*
 * buffer_test.c
 *
 *  Created on: 19/08/2012
 *      Author: flbulgarelli
 */

#include "../src/buffer.h"
#include <assert.h>
#include <string.h>
#include <stdio.h>
#include <malloc.h>

int main() {
  Buffer * buffer = buffer_new(10);
  assert(buffer_current_size(buffer) == 0);

  buffer_append_char(buffer, 'h');
  buffer_append_char(buffer, 'o');
  assert(buffer_current_size(buffer) == 2);

  buffer_append_chars(buffer, "la", 2);
  assert(buffer_current_size(buffer) == 4);

  buffer_append_chars(buffer, " mundo", 6);
  char * result = buffer_extract(buffer);
  assert(strcmp(result, "hola mundo") == 0);

  buffer_delete(&buffer);
  assert(buffer == NULL);

  free(result);
  result = NULL;
  printf("OK\n");
  return 0;
}
