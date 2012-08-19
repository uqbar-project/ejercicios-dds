/*
 * buffer.h
 *
 *  Created on: 13/08/2012
 *      Author: flbulgarelli
 */

#ifndef BUFFER_H_
#define BUFFER_H_

typedef struct {
  char * content;
  int current_size;
  int max_size;
} Buffer;

Buffer * buffer_new(int max_size);
void buffer_append_char(Buffer * self, char aChar);
void buffer_append_chars(Buffer * self, char * chars, int count);
char * buffer_extract(Buffer * self);
int  buffer_current_size(Buffer * self);
void buffer_delete(Buffer ** self);

#endif /* BUFFER_H_ */

