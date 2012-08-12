/*
 * adt.h
 *
 *  Created on: 12/08/2012
 *      Author: flbulgarelli
 */
#ifndef ADT_H_
#define ADT_H_

#define adt_declare(type)  typedef struct {} type
#define adt_define(type, definition)  \
  typedef struct definition _; \
  static type * new() { \
     return  (type *) instance_new(_); \
  }

#define self()     ((_*)(self))
#define self_delete()  \
  instance_delete(*self); \
  self = NULL

#endif /* ADT_H_ */
