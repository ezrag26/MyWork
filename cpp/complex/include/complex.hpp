#ifndef _MYWORK_COMPLEX_HPP_
#define _MYWORK_COMPLEX_HPP_

// methods that rely on the declarations of iostream types without having to 
// #include <iostream> headers themselves, which are large, complex and 
// slow to compile against.
#include <iosfwd>   // I/O declaration

namespace mywork
{

class Complex
{
public:
    Complex(double real_ = 0, double imag_ = 0);

    // CCtor, Assignment Operator, and Dtor generated by compiler

    Complex& operator+=(const Complex& comp_);
    Complex& operator-=(const Complex& comp_);
    Complex& operator*=(const Complex& comp_);
    Complex& operator/=(const Complex& comp_);

    void SetReal(const double real_);
    void SetImaginary(const double imag_);

    double GetReal() const;
    double GetImaginary() const;

private:
    double m_real;
    double m_imag;
};

std::ostream& operator<<(std::ostream& os_, const Complex& comp_);
std::istream& operator>>(std::istream& is_, Complex& comp_);

const Complex operator+(const Complex& comp1_, const Complex& comp2_);
const Complex operator-(const Complex& comp1_, const Complex& comp2_);
const Complex operator*(const Complex& comp1_, const Complex& comp2_);
const Complex operator/(const Complex& comp1_, const Complex& comp2_);

bool operator==(const Complex& comp1_, const Complex& comp2_);
bool operator!=(const Complex& comp1_, const Complex& comp2_);

} // mywork

#include "complex_impl.hpp"

#endif // _MYWORK_COMPLEX_HPP_
