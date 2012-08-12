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
#define instance_delete(self) free((void*)(self))

#endif /* INSTANCE_H_ */
