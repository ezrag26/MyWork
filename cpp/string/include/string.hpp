#ifndef _MYWORK_STRING_HPP_
#define _MYWORK_STRING_HPP_

#include <cstddef> // size_t

namespace mywork
{

class String
{
public:
    String(const char *string_ = ""); // purposely NOT explicit, want to support implicit conversions
    ~String();
    String(const String& other_);
    String& operator=(const String& other_);
    size_t Length() const;
    const char *CStr() const;

private:
    char *m_cstr;
};

} // mywork

#endif // _MYWORK_STRING_HPP_
