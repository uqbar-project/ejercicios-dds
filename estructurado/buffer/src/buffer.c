/*
 * buffer.c
 *
 *  Created on: 13/08/2012
 *      Author: flbulgarelli
 */

#include "buffer.h"
#include <assert.h>
#include <string.h>
#include <src/minilib/instance.h>

static void _buffer_expand(Buffer*self, int required_space);
static int _buffer_optimal_new_size(Buffer*self, int required_space);
static int _buffer_available_space(Buffer*self);

Buffer * buffer_new(int max_size) {
  Buffer * self = instance_new(Buffer);
  self->current_size = 0;
  self->max_size = max_size;
  self->content = instance_new_array(char, max_size);
  return self;
}

void buffer_append_char(Buffer * self, char a_char) {
  _buffer_expand(self, 1);
  self->content[self->current_size] = a_char;
  self->current_size++;
}

void buffer_append_chars(Buffer * self, char * chars, int count){
  _buffer_expand(self, count);
  memcpy(self->content + self->current_size, chars, count);
  self->current_size += count;
}

char * buffer_extract(Buffer * self) {
  assert(self->content != NULL);
  buffer_append_char(self, '\0');
  char * content = self->content;
  self->content = NULL;
  return content;
}

int buffer_current_size(Buffer * self ) {
  return self->current_size;
}


void buffer_delete(Buffer ** self) {
  if( (*self)->content != NULL ) {
    instance_delete((*self)->content);
  }
  instance_delete(*self);
}


static void _buffer_expand(Buffer*self, int required_space) {
  if(_buffer_available_space(self) < required_space) {
    int new_size = _buffer_optimal_new_size(self, required_space);
    self->max_size = new_size;

    char * new_content =  instance_new_array(char, new_size);
    memcpy(new_content, self->content, self->current_size);

    instance_delete_and_set(self->content, new_content);
  }
}

static int _buffer_available_space(Buffer*self) {
  return self->max_size - self->current_size;
}

static int _buffer_optimal_new_size(Buffer*self, int required_space) {
  return 2 * (required_space - _buffer_available_space(self)) + 10;
}


