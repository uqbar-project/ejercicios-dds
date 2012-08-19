/*
 * instance.h
 *
 *  Created on: 12/08/2012
 *      Author: flbulgarelli
 */
#ifndef INSTANCE_H_
#define INSTANCE_H_

#include <malloc.h>

#define instance_new(type) ((type*)malloc(sizeof(type)))
#define instance_new_array(type, size) ((type*)malloc(sizeof(type) * (size)))
#define instance_delete(self) free((void*)(self)) ; (self) = NULL
#define instance_delete_and_set(self, other) free((void*)(self)) ; (self) = (other)

#endif /* INSTANCE_H_ */
