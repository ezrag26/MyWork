#ifndef __MYWORK_QUICKSORT_H__
#define __MYWORK_QUICKSORT_H__

#include <stddef.h> /* size_t */

void QuickSort(void *base, size_t nel, size_t width, int (*cmp)(const void *, const void *));

#endif /* __MYWORK_QUICKSORT_H__ */
